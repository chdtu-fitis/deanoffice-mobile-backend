package ua.edu.chdtu.deanoffice.mobile.backend.infoAboutStudent;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.Student;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.StudentDegree;
import ua.edu.chdtu.deanoffice.mobile.backend.security.JwtUtil;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InformationAboutStudentService {
    private JwtUtil jwtUtil = new JwtUtil();

    private final RestTemplate restTemplate;

    public InformationAboutStudentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Student getStudentInfo(String token) {
        String url = "http://localhost:8080/students/" + jwtUtil.parseToken(token) + "/degrees";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjAzOTUyNjMwLCJpc3MiOiIxIiwicm9sIjpbIlJPTEVfREVBTk9GRklDRVIiXX0.AUJUnlbXqVvxGS53XDUTL6Rx7tb-FYLV8OQStLN47BQYOd_4_xazumNXzWXm1T-8P-sNnsd2NoV-aFdCz6GQSQ");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Student> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Student.class, 1);
        Student student = response.getBody();
        Set<StudentDegree> degrees = student.getDegrees().stream().filter(x -> x.isActive() != false).collect(Collectors.toSet());
        student.setDegrees(degrees);

        return student;
    }
}