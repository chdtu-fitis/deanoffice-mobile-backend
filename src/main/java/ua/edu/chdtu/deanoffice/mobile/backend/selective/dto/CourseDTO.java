package ua.edu.chdtu.deanoffice.mobile.backend.selective.dto;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.student.dto.NamedDTO;

import java.math.BigDecimal;

@Getter
@Setter
public class CourseDTO {
    private int id;
    private NamedWithEngDTO courseName;
    private Integer semester;
    private NamedDTO knowledgeControl;
    private Integer hours;
    private BigDecimal credits;
    private Integer hoursPerCredit;
}
