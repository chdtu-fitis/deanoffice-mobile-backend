package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ua.edu.chdtu.deanoffice.mobile.backend.currentYear.CurrentYearService;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.CheckSelectiveCoursesStudentDegreeDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCourseDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCoursesStudentDegreeDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCoursesStudentDegreeWriteDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.student.Semester;
import ua.edu.chdtu.deanoffice.mobile.backend.student.StudentService;

import java.util.Arrays;
import java.util.Collections;

import static ua.edu.chdtu.deanoffice.mobile.backend.security.SecurityConstants.TOKEN;

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

    public SelectiveCourses getSelectiveCourses(int studentDegreeId) {
        SelectiveCourses selectiveCourses = new SelectiveCourses();
        Semester semester = studentService.getStudentSemester(studentDegreeId);

        selectiveCourses.setSelectiveCoursesFirstSemester(Arrays.asList(getSelectiveCoursesForSemester(semester.getFirst(), studentDegreeId)));
        selectiveCourses.setSelectiveCoursesSecondSemester(Arrays.asList(getSelectiveCoursesForSemester(semester.getSecond(), studentDegreeId)));

        return selectiveCourses;
    }

    private SelectiveCourseDTO[] getSelectiveCoursesForSemester(int semester, int studentDegreeId) {
        String url = "http://localhost:8080/selective-courses?studyYear=" + currentYearService.getYear() + "&degreeId=" + studentService.getDegreeId(studentDegreeId) + "&semester=" + semester;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", TOKEN);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<SelectiveCourseDTO[]> response = this.restTemplate.exchange(url, HttpMethod.GET, request, SelectiveCourseDTO[].class, 1);
        SelectiveCourseDTO[] selectiveCourseDTOS = response.getBody();
        return selectiveCourseDTOS;
    }

    public ResponseEntity<SelectiveCoursesStudentDegreeDTO> recordOnSelectiveCourses(SelectiveCoursesStudentDegreeWriteDTO selectiveCoursesStudentDegreeWriteDTO) {
        try {
            String url = "http://localhost:8080/selective-courses/registration";
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", TOKEN);

            HttpEntity<SelectiveCoursesStudentDegreeWriteDTO> request = new HttpEntity(selectiveCoursesStudentDegreeWriteDTO, headers);
            ResponseEntity<SelectiveCoursesStudentDegreeDTO> response = restTemplate.postForEntity(url, request, SelectiveCoursesStudentDegreeDTO.class);

            return ResponseEntity.ok(response.getBody());
        } catch (HttpClientErrorException e) {
            return new ResponseEntity(e.getLocalizedMessage(), e.getStatusCode());
        }
    }

    public CheckSelectiveCoursesStudentDegreeDTO checkSelectiveCoursesStudentDegree(int studentDegreeId) {
        String url = "http://localhost:8080/selective-courses/student-courses?studyYear=" + currentYearService.getYear() + "&studentDegreeId=" + studentDegreeId;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", TOKEN);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<CheckSelectiveCoursesStudentDegreeDTO> response = restTemplate.exchange(url, HttpMethod.GET, request, CheckSelectiveCoursesStudentDegreeDTO.class, 1);

        return response.getBody();
    }
}
