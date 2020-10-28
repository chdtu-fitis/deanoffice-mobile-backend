package ua.edu.chdtu.deanoffice.mobile.backend.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDegreeDTO {
    private StudentGroupDTO studentGroup;
    private SpecializationDTO specialization;
    private boolean active;
}
