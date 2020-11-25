package ua.edu.chdtu.deanoffice.mobile.backend.selective.model;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.superclasses.AcademicTitle;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.superclasses.Sex;
import ua.edu.chdtu.deanoffice.mobile.backend.student.model.Named;

import javax.validation.constraints.Min;

@Getter
@Setter
public class Teacher {
    @Min(1)
    private int id;
    private String surname;
    private String name;
    private String patronimic;
    private Sex sex;
    private boolean active;
    private AcademicTitle academicTitle;
    private Named department;
    private Named position;
    private ScientificDegree scientificDegree;
}
