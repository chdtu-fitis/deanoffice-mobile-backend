package ua.edu.chdtu.deanoffice.mobile.backend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.chdtu.deanoffice.mobile.backend.student.dto.StudentDTO;

import static ua.edu.chdtu.deanoffice.mobile.backend.general.mapper.Mapper.map;

@RestController
public class StudentController {
    private StudentService restService;

    @Autowired
    public StudentController(StudentService restService) {
        this.restService = restService;
    }

    @GetMapping("/students")
    public ResponseEntity getInfoAboutStudent() {
        return ResponseEntity.ok(map(restService.getStudentInfo(), StudentDTO.class));
    }
}
