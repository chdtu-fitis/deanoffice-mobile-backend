package ua.edu.chdtu.deanoffice.mobile.backend.selective.model;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.student.model.Named;

import java.math.BigDecimal;

@Getter
@Setter
public class Course {
    private int id;
    private NamedWithEng courseName;
    private Integer semester;
    private Named knowledgeControl;
    private Integer hours;
    private BigDecimal credits;
    private Integer hoursPerCredit;
}
