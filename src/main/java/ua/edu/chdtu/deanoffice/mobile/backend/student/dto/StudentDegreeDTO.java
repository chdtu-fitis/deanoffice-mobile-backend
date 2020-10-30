package ua.edu.chdtu.deanoffice.mobile.backend.student.dto;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.Payment;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.TuitionForm;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.TuitionTerm;

@Getter
@Setter
public class StudentDegreeDTO {
    private int id;
    private StudentGroupDTO studentGroup;
    private SpecializationDTO specialization;
    private Payment payment;
    private TuitionForm tuitionForm;
    private TuitionTerm tuitionTerm;
    private boolean active;
}
