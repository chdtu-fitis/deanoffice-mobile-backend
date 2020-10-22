package ua.edu.chdtu.deanoffice.mobile.backend.student.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StudentDTO {
    private String name;
    private String surname;
    private String patronimic;
    private Set<StudentDegreeDTO> degrees;
}
