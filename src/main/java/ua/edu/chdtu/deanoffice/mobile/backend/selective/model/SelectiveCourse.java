package ua.edu.chdtu.deanoffice.mobile.backend.selective.model;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.superclasses.TypeCycle;
import ua.edu.chdtu.deanoffice.mobile.backend.student.model.Named;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
public class SelectiveCourse {
    private Integer id;
    private boolean available;
    private Course course;
    private Teacher teacher;
    private Named degree;
    private Department department;
    @Enumerated(EnumType.STRING)
    private TypeCycle trainingCycle;
    private String description;
    private Integer studyYear;
}
