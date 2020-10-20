package ua.edu.chdtu.deanoffice.mobile.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class StudentGroup {
    @Id
    private int id;
    private String name;
    @ManyToOne
    private Specialization specialization;
}
