package ua.edu.chdtu.deanoffice.mobile.backend.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGroupDTO {
    private int id;
    private String name;
    private int studySemesters;
    private int creationYear;
    private int beginYears;
}
