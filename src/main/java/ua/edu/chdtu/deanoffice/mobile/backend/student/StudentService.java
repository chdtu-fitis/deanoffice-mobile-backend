package ua.edu.chdtu.deanoffice.mobile.backend.student;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.edu.chdtu.deanoffice.mobile.backend.Constants;
import ua.edu.chdtu.deanoffice.mobile.backend.currentYear.CurrentYearService;
import ua.edu.chdtu.deanoffice.mobile.backend.security.JwtUtil;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.HttpUtil;
import ua.edu.chdtu.deanoffice.mobile.backend.student.model.Student;
import ua.edu.chdtu.deanoffice.mobile.backend.student.model.StudentDegree;
import ua.edu.chdtu.deanoffice.mobile.backend.student.model.StudentGroup;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import static ua.edu.chdtu.deanoffice.mobile.backend.security.SecurityConstants.TOKEN;

@Service
public class StudentService {
    CurrentYearService currentYearService;
    private final RestTemplate restTemplate;

    public StudentService(RestTemplateBuilder restTemplateBuilder, CurrentYearService currentYearService) {
        this.restTemplate = restTemplateBuilder.build();
        this.currentYearService = currentYearService;
    }

    public Student getStudent() {
        String url = "http://localhost:8080/students/" + JwtUtil.getUserIdInt() + "/degrees";
        HttpEntity request = new HttpEntity(HttpUtil.getHeaders());
        ResponseEntity<Student> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Student.class, 1);
        Student student = response.getBody();
        Set<StudentDegree> degrees = student.getDegrees().stream().filter(x -> x.isActive()).collect(Collectors.toSet());
        student.setDegrees(degrees);
        return student;
    }

    public int getDegreeId(int studentDegreeId) {
        int id = -1;
        Student student = getStudent();
        for (StudentDegree studentDegree : student.getDegrees()) {
            if (studentDegree.getId() == studentDegreeId)
                id = studentDegree.getSpecialization().getDegree().getId();
        }
        return id;
    }

    private int getGroupId(int studentDegreeId) {
        int groupId = -1;
        Student student = getStudent();
        for (StudentDegree studentDegree : student.getDegrees()) {
            if(studentDegree.getId() == studentDegreeId)
                groupId = studentDegree.getStudentGroup().getId();
        }
        return groupId;
    }

    public Semester getStudentSemester(int studentDegreeId) {
        StudentGroup studentGroup = getStudentGroup(getGroupId(studentDegreeId));
        int year = currentYearService.getYear() - studentGroup.getCreationYear() + studentGroup.getBeginYears();
        Semester semester = new Semester();
        semester.setFirst(year * 2 - 1);
        semester.setSecond(year * 2);
        return semester;
    }

    public StudentGroup getStudentGroup(int groupId) {
        String url = Constants.BASE_URL + "/groups/" + groupId;
        HttpEntity request = new HttpEntity(HttpUtil.getHeaders());
        ResponseEntity<StudentGroup> response = this.restTemplate.exchange(url, HttpMethod.GET, request, StudentGroup.class, 1);
        StudentGroup studentGroup = response.getBody();
        return studentGroup;
    }
}
