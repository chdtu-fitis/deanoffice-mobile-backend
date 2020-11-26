package ua.edu.chdtu.deanoffice.mobile.backend.student.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Specialization {
    private String name;
    private Speciality speciality;
    private Degree degree;
}
