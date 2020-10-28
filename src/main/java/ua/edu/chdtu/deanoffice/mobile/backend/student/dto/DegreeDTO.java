package ua.edu.chdtu.deanoffice.mobile.backend.student.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class DegreeDTO {
        @Id
        private int id;
        private String name;
}
