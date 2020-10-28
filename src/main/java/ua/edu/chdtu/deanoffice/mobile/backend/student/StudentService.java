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

@Service
public class StudentService {
    CurrentYearService currentYearService;
    private final RestTemplate restTemplate;

    public StudentService(RestTemplateBuilder restTemplateBuilder, CurrentYearService currentYearService) {
        this.restTemplate = restTemplateBuilder.build();
        this.currentYearService = currentYearService;
    }

    public StudentDTO getStudentInfo() {
        String url = "http://localhost:8080/students/" + JwtUtil.getUserIdInt() + "/degrees";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA0MDQ5NDY0LCJpc3MiOiIxIiwicm9sIjpbIlJPTEVfREVBTk9GRklDRVIiXX0.Z2ejurlCnsvfgsdj9u5SZ-_smdd1j_a73Y7v0HMaOgumJtxqpYczJ-EoGWRKpSZFP-ZO-omcM-WLgMAH84-s1Q");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<StudentDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request, StudentDTO.class, 1);
        StudentDTO student = response.getBody();
        Set<StudentDegreeDTO> degrees = student.getDegrees().stream().filter(x -> x.isActive()).collect(Collectors.toSet());
        student.setDegrees(degrees);

        int groupId = -1;
        for(StudentDegreeDTO studentDegree : degrees) {
            groupId = studentDegree.getStudentGroup().getId();
        }

        student.setYear(getStudentYear(getStudentGroup(groupId)));
        return student;
    }

    public int getUserDegree() {
        StudentDTO student = getStudentInfo();
        int id = -1;

        Set<StudentDegreeDTO> degrees = student.getDegrees();
        for(StudentDegreeDTO studentDegree : degrees)
            id = studentDegree.getSpecialization().getDegree().getId();
        return id;
    }

    private int getStudentYear(StudentGroupDTO studentGroup) {
        return currentYearService.getYear() - studentGroup.getCreationYear() + studentGroup.getBeginYears();
    }

    private StudentGroupDTO getStudentGroup(int groupId) {

        String url = "http://localhost:8080/groups/" + groupId;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA0MDQ5NDY0LCJpc3MiOiIxIiwicm9sIjpbIlJPTEVfREVBTk9GRklDRVIiXX0.Z2ejurlCnsvfgsdj9u5SZ-_smdd1j_a73Y7v0HMaOgumJtxqpYczJ-EoGWRKpSZFP-ZO-omcM-WLgMAH84-s1Q");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<StudentGroupDTO> response = this.restTemplate.exchange(url, HttpMethod.GET, request, StudentGroupDTO.class, 1);
        StudentGroupDTO studentGroup = response.getBody();

        return studentGroup;
    }
}