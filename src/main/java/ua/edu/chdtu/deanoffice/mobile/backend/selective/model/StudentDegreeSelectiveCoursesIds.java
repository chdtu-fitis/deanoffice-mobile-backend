package ua.edu.chdtu.deanoffice.mobile.backend.selective.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDegreeSelectiveCoursesIds {
    private ExistingId studentDegree;
    private List<ExistingId> selectiveCourses;
}
