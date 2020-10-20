package ua.edu.chdtu.deanoffice.mobile.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Specialization {
    @Id
    private int id;
    private String name;
    @ManyToOne
    private Speciality speciality;
    @ManyToOne
    private Faculty faculty;
    @ManyToOne
    private Degree degree;
}
