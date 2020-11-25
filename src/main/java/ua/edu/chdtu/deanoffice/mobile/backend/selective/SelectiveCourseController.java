package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.model.SelectiveCoursesStudentDegree;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.model.StudentDegreeSelectiveCoursesIds;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.model.SelectiveCoursesStudentDegreeWrite;

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
    public ResponseEntity<StudentDegreeSelectiveCoursesIds> getConfirmedSelectiveCourses(@RequestBody SelectiveCoursesStudentDegreeWrite selectiveCoursesStudentDegreeWrite) {
        return selectiveCourseService.recordOnSelectiveCourses(selectiveCoursesStudentDegreeWrite);
    }

    @GetMapping("/student-degree")
    public ResponseEntity<SelectiveCoursesStudentDegree> checkSelectiveCoursesStudentDegree(@RequestParam int studentDegreeId) {
        return ResponseEntity.ok(selectiveCourseService.getSelectiveCoursesStudentDegree(studentDegreeId));
    }
}
