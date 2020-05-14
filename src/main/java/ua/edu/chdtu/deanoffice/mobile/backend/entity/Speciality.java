package ua.edu.chdtu.deanoffice.mobile.backend.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Speciality {
    @Id
    private int id;
    private String name;
    private String code;
    private String fieldOfStudyCode;
    private String fieldOfStudy;
    private String fieldOfStudyEng;
    private boolean active;
}
