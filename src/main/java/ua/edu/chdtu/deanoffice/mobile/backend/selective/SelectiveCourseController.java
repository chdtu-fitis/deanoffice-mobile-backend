package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.CheckSelectiveCoursesStudentDegreeDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCoursesStudentDegreeDTO;
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
    public ResponseEntity<SelectiveCoursesStudentDegreeDTO> getConfirmedSelectiveCourses(@RequestBody SelectiveCoursesStudentDegreeWriteDTO selectiveCoursesStudentDegreeWriteDTO) {
        return selectiveCourseService.recordOnSelectiveCourses(selectiveCoursesStudentDegreeWriteDTO);
    }

    @GetMapping("/check")
    public ResponseEntity<CheckSelectiveCoursesStudentDegreeDTO> checkSelectiveCoursesStudentDegree(@RequestParam int studentDegreeId) {
        return ResponseEntity.ok(selectiveCourseService.checkSelectiveCoursesStudentDegree(studentDegreeId));
    }
}
