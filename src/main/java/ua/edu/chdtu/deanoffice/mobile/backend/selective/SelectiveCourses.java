package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.model.SelectiveCourse;

import java.util.List;

@Getter
@Setter
public class SelectiveCourses {
    private List<SelectiveCourse> selectiveCoursesFirstSemester;
    private List<SelectiveCourse> selectiveCoursesSecondSemester;
}
