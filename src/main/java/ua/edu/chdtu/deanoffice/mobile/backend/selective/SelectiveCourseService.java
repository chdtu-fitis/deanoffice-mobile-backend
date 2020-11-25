package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import ua.edu.chdtu.deanoffice.mobile.backend.Constants;
import ua.edu.chdtu.deanoffice.mobile.backend.currentYear.CurrentYearService;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.model.SelectiveCoursesStudentDegree;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.model.SelectiveCourse;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.model.StudentDegreeSelectiveCoursesIds;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.model.SelectiveCoursesStudentDegreeWrite;
import ua.edu.chdtu.deanoffice.mobile.backend.student.Semester;
import ua.edu.chdtu.deanoffice.mobile.backend.student.StudentService;

import java.util.Arrays;

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

    private SelectiveCourse[] getSelectiveCoursesForSemester(int semester, int studentDegreeId) {
        String url = Constants.BASE_URL + "/selective-courses?studyYear=" + currentYearService.getYear() + "&degreeId=" + studentService.getDegreeId(studentDegreeId) + "&semester=" + semester;
        HttpEntity request = new HttpEntity(HttpUtil.getHeaders());
        ResponseEntity<SelectiveCourse[]> response = this.restTemplate.exchange(url, HttpMethod.GET, request, SelectiveCourse[].class, 1);
        SelectiveCourse[] selectiveCourses = response.getBody();
        return selectiveCourses;
    }

    public ResponseEntity<StudentDegreeSelectiveCoursesIds> recordOnSelectiveCourses(SelectiveCoursesStudentDegreeWrite selectiveCoursesStudentDegreeWrite) {
        try {
            String url = Constants.BASE_URL + "/selective-courses/registration";
            HttpEntity<SelectiveCoursesStudentDegreeWrite> request = new HttpEntity(selectiveCoursesStudentDegreeWrite, HttpUtil.getHeaders());
            ResponseEntity<StudentDegreeSelectiveCoursesIds> response = restTemplate.postForEntity(url, request, StudentDegreeSelectiveCoursesIds.class);
            return ResponseEntity.ok(response.getBody());
        } catch (HttpClientErrorException e) {
            return new ResponseEntity(e.getLocalizedMessage(), e.getStatusCode());
        }
    }

    public SelectiveCoursesStudentDegree getSelectiveCoursesStudentDegree(int studentDegreeId) {
        String url = Constants.BASE_URL + "/selective-courses/student-courses?studyYear=" + currentYearService.getYear() + "&studentDegreeId=" + studentDegreeId;
        HttpEntity request = new HttpEntity(HttpUtil.getHeaders());
        ResponseEntity<SelectiveCoursesStudentDegree> response = restTemplate.exchange(url, HttpMethod.GET, request, SelectiveCoursesStudentDegree.class, 1);
        return response.getBody();
    }
}
