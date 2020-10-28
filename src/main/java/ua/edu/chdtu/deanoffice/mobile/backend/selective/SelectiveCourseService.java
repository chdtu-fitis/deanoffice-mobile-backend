package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.edu.chdtu.deanoffice.mobile.backend.currentYear.CurrentYearService;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCourseDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.student.StudentService;

import java.util.Collections;

@Service
public class SelectiveCourseService {
    private final RestTemplate restTemplate;
    private StudentService studentService;
    private CurrentYearService currentYearService;

    public SelectiveCourseService(RestTemplateBuilder restTemplateBuilder, StudentService studentService, CurrentYearService currentYearService) {
        this.restTemplate = restTemplateBuilder.build();
        this.studentService = studentService;
        this.currentYearService = currentYearService;
    }

    public SelectiveCourseDTO[] getSelectiveCourses(int semester) {
        String url = "http://localhost:8080/selective-courses?studyYear=" + (currentYearService.getYear() + 1) + "&degreeId=" + studentService.getUserDegree() + "&semester=" + semester;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA0MDQ5NDY0LCJpc3MiOiIxIiwicm9sIjpbIlJPTEVfREVBTk9GRklDRVIiXX0.Z2ejurlCnsvfgsdj9u5SZ-_smdd1j_a73Y7v0HMaOgumJtxqpYczJ-EoGWRKpSZFP-ZO-omcM-WLgMAH84-s1Q");

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<SelectiveCourseDTO[]> response = this.restTemplate.exchange(url, HttpMethod.GET, request, SelectiveCourseDTO[].class, 1);

        return response.getBody();
    }


}
