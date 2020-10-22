package ua.edu.chdtu.deanoffice.mobile.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class StudentDegree {
    @Id
    private int id;
    private String payment;
    @ManyToOne
    private Specialization specialization;
    @ManyToOne
    private Student student;
    @ManyToOne
    private StudentGroup studentGroup;
    private String tuitionForm;
    private boolean active;
}
