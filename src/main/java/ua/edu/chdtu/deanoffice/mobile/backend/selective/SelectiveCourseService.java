package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.edu.chdtu.deanoffice.mobile.backend.currentYear.CurrentYearService;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCoursesDTO;
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



    private SelectiveCoursesDTO[] getSelectiveCoursesForSemester(int semester, int studentDegreeId) {
        String url = "http://localhost:8080/selective-courses?studyYear=" + (currentYearService.getYear() + 1) + "&degreeId=" + studentService.getDegreeId(studentDegreeId) + "&semester=" + semester;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", TOKEN);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<SelectiveCoursesDTO[]> response = this.restTemplate.exchange(url, HttpMethod.GET, request, SelectiveCoursesDTO[].class, 1);
        SelectiveCoursesDTO[] selectiveCourseDTOS = response.getBody();
        return selectiveCourseDTOS;
    }
}
