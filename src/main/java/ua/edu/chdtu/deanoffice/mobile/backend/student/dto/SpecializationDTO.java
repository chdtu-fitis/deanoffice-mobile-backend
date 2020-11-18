package ua.edu.chdtu.deanoffice.mobile.backend.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecializationDTO {
    private String name;
    private SpecialityDTO speciality;
    private DegreeDTO degree;
}
