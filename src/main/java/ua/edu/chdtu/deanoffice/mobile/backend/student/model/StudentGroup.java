package ua.edu.chdtu.deanoffice.mobile.backend.student.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentGroup {
    private int id;
    private String name;
    private int studySemesters;
    private int creationYear;
    private int beginYears;
}
