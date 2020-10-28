package ua.edu.chdtu.deanoffice.mobile.backend.selective.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDTO {
    private int id;
    private String name;
    private boolean active = true;
    private String abbr;
}
