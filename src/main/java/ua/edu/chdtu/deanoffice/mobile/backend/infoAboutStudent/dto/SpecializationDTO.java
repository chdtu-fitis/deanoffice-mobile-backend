package ua.edu.chdtu.deanoffice.mobile.backend.infoAboutStudent.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecializationDTO {
    private String name;
    private SpecialityDTO speciality;
    private NamedDTO degree;
}
