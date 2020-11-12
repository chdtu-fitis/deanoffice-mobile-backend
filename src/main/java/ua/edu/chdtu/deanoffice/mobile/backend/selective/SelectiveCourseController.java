package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCoursesStudentDegreeWriteDTO;

@RestController
@RequestMapping("/selective-courses")
public class SelectiveCourseController {
    private SelectiveCourseService selectiveCourseService;

    @Autowired
    public SelectiveCourseController(SelectiveCourseService selectiveCourseService) {
        this.selectiveCourseService = selectiveCourseService;
    }

    @GetMapping
    public ResponseEntity<SelectiveCourses> getSelectiveCourses(@RequestParam int studentDegreeId) {
        return ResponseEntity.ok(selectiveCourseService.getSelectiveCourses(studentDegreeId));
    }

    @PostMapping("/registration")
    public ResponseEntity getConfirmedSelectiveCourses(@RequestBody SelectiveCoursesStudentDegreeWriteDTO selectiveCoursesStudentDegreeWriteDTO) {
        System.out.println("StudentDegree: " + selectiveCoursesStudentDegreeWriteDTO.getStudentDegreeId());
        selectiveCoursesStudentDegreeWriteDTO.getSelectiveCourses().forEach(x -> System.out.println(x));
        return ResponseEntity.ok(selectiveCourseService.recordOnSelectiveCourse(selectiveCoursesStudentDegreeWriteDTO));
    }
}
