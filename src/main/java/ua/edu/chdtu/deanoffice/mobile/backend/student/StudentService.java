package ua.edu.chdtu.deanoffice.mobile.backend.student;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.edu.chdtu.deanoffice.mobile.backend.currentYear.CurrentYearService;
import ua.edu.chdtu.deanoffice.mobile.backend.security.JwtUtil;
import ua.edu.chdtu.deanoffice.mobile.backend.student.dto.StudentDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.student.dto.StudentDegreeDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.student.dto.StudentGroupDTO;

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

    public StudentDTO getStudent() {
        String url = "http://localhost:8080/students/" + JwtUtil.getUserIdInt() + "/degrees";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", TOKEN);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<StudentDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request, StudentDTO.class, 1);
        StudentDTO student = response.getBody();
        Set<StudentDegreeDTO> degrees = student.getDegrees().stream().filter(x -> x.isActive()).collect(Collectors.toSet());
        student.setDegrees(degrees);

        return student;
    }

    public int getDegreeId(int studentDegreeId) {
        int id = -1;
        StudentDTO student = getStudent();

        for (StudentDegreeDTO studentDegree : student.getDegrees()) {
            if (studentDegree.getId() == studentDegreeId)
                id = studentDegree.getSpecialization().getDegree().getId();
        }

        return id;
    }

    private int getGroupId(int studentDegreeId) {
        int groupId = -1;
        StudentDTO student = getStudent();

        for (StudentDegreeDTO studentDegree : student.getDegrees()) {
            if(studentDegree.getId() == studentDegreeId)
                groupId = studentDegree.getStudentGroup().getId();
        }

        return groupId;
    }

    public Semester getStudentSemester(int studentDegreeIds) {
        StudentGroupDTO studentGroup = getStudentGroup(getGroupId(studentDegreeIds));
        int year = currentYearService.getYear() - studentGroup.getCreationYear() + studentGroup.getBeginYears();

        Semester semester = new Semester();
        semester.setFirst(year % 2 == 0 ? year - 1 : year);
        semester.setSecond(year % 2 == 0 ? year : year + 1);

        return semester;
    }

    public StudentGroupDTO getStudentGroup(int groupId) {
        String url = "http://localhost:8080/groups/" + groupId;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", TOKEN);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<StudentGroupDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request, StudentGroupDTO.class, 1);
        StudentGroupDTO studentGroup = response.getBody();

        return studentGroup;
    }
}