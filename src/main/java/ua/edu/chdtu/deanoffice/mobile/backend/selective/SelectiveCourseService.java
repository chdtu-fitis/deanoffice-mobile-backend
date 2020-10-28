package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.edu.chdtu.deanoffice.mobile.backend.currentYear.CurrentYearService;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCourseDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.student.Semester;
import ua.edu.chdtu.deanoffice.mobile.backend.student.StudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public SelectiveCourses getSelectiveCourses() {
        SelectiveCourses selectiveCourses = new SelectiveCourses();
        Semester semester = studentService.getStudentSemester();

        selectiveCourses.setSelectiveCoursesFirstSemester(arrayToList(getSelectiveCoursesForSemester(semester.getFirst())));
        selectiveCourses.setSelectiveCoursesSecondSemester(arrayToList(getSelectiveCoursesForSemester(semester.getSecond())));

        return selectiveCourses;
    }

    private SelectiveCourseDTO[] getSelectiveCoursesForSemester(int semester) {
        String url = "http://localhost:8080/selective-courses?studyYear=" + (currentYearService.getYear() + 1) + "&degreeId=" + studentService.getUserDegree() + "&semester=" + semester;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", TOKEN);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<SelectiveCourseDTO[]> response = this.restTemplate.exchange(url, HttpMethod.GET, request, SelectiveCourseDTO[].class, 1);
        SelectiveCourseDTO[] selectiveCourseDTOS = response.getBody();
        return selectiveCourseDTOS;
    }

    private static <T> List<T> arrayToList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T object : array) {
            list.add(object);
        }

        return list;
    }
}
