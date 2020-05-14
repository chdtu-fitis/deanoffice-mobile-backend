package ua.edu.chdtu.deanoffice.mobile.backend.example;

import org.springframework.stereotype.Service;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ExampleStudent;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExampleService {
    public List<ExampleStudent> getStudents() {
        ExampleStudent student1 = new ExampleStudent(1, "Петренко Петро");
        ExampleStudent student2 = new ExampleStudent(2, "Іваненко Іван");
        List<ExampleStudent> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        return students;
    }
}
