package ua.edu.chdtu.deanoffice.mobile.backend.student.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class Degree {
    @Id
    private int id;
    private String name;
}
