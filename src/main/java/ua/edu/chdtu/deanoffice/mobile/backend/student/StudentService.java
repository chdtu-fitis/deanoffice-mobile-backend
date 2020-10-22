package ua.edu.chdtu.deanoffice.mobile.backend.student;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.Student;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.StudentDegree;
import ua.edu.chdtu.deanoffice.mobile.backend.security.JwtUtil;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final RestTemplate restTemplate;

    public StudentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Student getStudentInfo() {
        String url = "http://localhost:8080/students/" + JwtUtil.getUserIdInt() + "/degrees";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA0MDQ5NDY0LCJpc3MiOiIxIiwicm9sIjpbIlJPTEVfREVBTk9GRklDRVIiXX0.Z2ejurlCnsvfgsdj9u5SZ-_smdd1j_a73Y7v0HMaOgumJtxqpYczJ-EoGWRKpSZFP-ZO-omcM-WLgMAH84-s1Q");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Student> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Student.class, 1);
        Student student = response.getBody();
        Set<StudentDegree> degrees = student.getDegrees().stream().filter(x -> x.isActive()).collect(Collectors.toSet());
        student.setDegrees(degrees);

        return student;
    }
}