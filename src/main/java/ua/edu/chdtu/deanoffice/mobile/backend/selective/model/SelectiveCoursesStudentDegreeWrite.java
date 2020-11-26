package ua.edu.chdtu.deanoffice.mobile.backend.selective.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class SelectiveCoursesStudentDegreeWrite {
    @NotNull
    private List<Integer> selectiveCourses;
    @NotNull
    private ExistingId studentDegree;
}
