package ua.edu.chdtu.deanoffice.mobile.backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ApplicationUser {

    @Id
    private int id;
    private String username;
    private String password;
}
