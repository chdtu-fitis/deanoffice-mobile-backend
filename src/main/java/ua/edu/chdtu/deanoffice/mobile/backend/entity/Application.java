package ua.edu.chdtu.deanoffice.mobile.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Application {
    @Id
    private int id;
    @ManyToOne
    private ApplicationType applicationType;
    private String header;
    private String body;
}
