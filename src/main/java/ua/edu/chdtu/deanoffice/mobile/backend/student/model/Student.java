package ua.edu.chdtu.deanoffice.mobile.backend.student.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Student {
    private String name;
    private String surname;
    private String patronimic;
    private Set<StudentDegree> degrees;
}
