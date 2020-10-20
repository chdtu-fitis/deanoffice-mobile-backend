package ua.edu.chdtu.deanoffice.mobile.backend.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Data
public class ApplicationUser {
    @Id
    private int id;
    private String username;
    private String password;
}
