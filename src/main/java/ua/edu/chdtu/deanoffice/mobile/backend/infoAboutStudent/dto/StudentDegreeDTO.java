package ua.edu.chdtu.deanoffice.mobile.backend.infoAboutStudent.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDegreeDTO {
    private NamedDTO studentGroup;
    private SpecializationDTO specialization;
    private boolean active;
}
