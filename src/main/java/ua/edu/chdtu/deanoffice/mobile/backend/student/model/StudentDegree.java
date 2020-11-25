package ua.edu.chdtu.deanoffice.mobile.backend.student.model;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.Payment;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.TuitionForm;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.TuitionTerm;

@Getter
@Setter
public class StudentDegree {
    private int id;
    private StudentGroup studentGroup;
    private Specialization specialization;
    private Payment payment;
    private TuitionForm tuitionForm;
    private TuitionTerm tuitionTerm;
    private boolean active;
}
