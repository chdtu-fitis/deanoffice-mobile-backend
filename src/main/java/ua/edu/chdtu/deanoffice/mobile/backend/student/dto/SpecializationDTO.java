package ua.edu.chdtu.deanoffice.mobile.backend.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecializationDTO {
    private String name;
    private NamedDTO speciality;
    private NamedDTO degree;
}
