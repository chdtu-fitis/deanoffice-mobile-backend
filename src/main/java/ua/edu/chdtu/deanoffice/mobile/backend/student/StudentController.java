package ua.edu.chdtu.deanoffice.mobile.backend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private StudentService restService;

    @Autowired
    public StudentController(StudentService restService) {
        this.restService = restService;
    }

    @GetMapping("/students")
    public ResponseEntity getInfoAboutStudent() {
        return ResponseEntity.ok(restService.getStudentInfo());
    }
}
