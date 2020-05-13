package ua.edu.chdtu.deanoffice.mobile.backend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExampleStudent {
    private int id;
    private String name;

    public ExampleStudent() {}

    public ExampleStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
