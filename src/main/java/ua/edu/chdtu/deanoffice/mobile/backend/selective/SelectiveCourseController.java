package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelectiveCourseController {
    private SelectiveCourseService selectiveCourseService;

    @Autowired
    public SelectiveCourseController(SelectiveCourseService selectiveCourseService) {
        this.selectiveCourseService = selectiveCourseService;
    }

    @GetMapping("/selective-courses")
    public ResponseEntity<SelectiveCourses> getSelectiveCourses(@RequestParam int studentDegreeId) {
        return ResponseEntity.ok(selectiveCourseService.getSelectiveCourses(studentDegreeId));
    }
}
