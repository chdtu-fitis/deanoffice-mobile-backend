package ua.edu.chdtu.deanoffice.mobile.backend.selective.dto;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.superclasses.AcademicTitle;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.superclasses.Sex;
import ua.edu.chdtu.deanoffice.mobile.backend.student.dto.NamedDTO;

import javax.validation.constraints.Min;

@Getter
@Setter
public class TeacherDTO {
    @Min(1)
    private int id;
    private String surname;
    private String name;
    private String patronimic;
    private Sex sex;
    private boolean active;
    private AcademicTitle academicTitle;
    private NamedDTO department;
    private NamedDTO position;
    private ScientificDegreeDTO scientificDegree;
}
