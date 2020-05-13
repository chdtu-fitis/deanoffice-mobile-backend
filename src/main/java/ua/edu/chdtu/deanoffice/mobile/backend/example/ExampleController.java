package ua.edu.chdtu.deanoffice.mobile.backend.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ExampleStudent;

import java.util.List;

@RestController
public class ExampleController {
    private ExampleService exampleService;

    private ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/example")
    public ResponseEntity<List<ExampleStudent>> getExampleStudents() {
        List<ExampleStudent> students = exampleService.getStudents();
        return ResponseEntity.ok(students);
    }
}
