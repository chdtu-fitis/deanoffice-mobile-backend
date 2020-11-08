package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCourseDTO;

import java.util.List;

@Getter
@Setter
public class SelectiveCourses {
    private List<SelectiveCourseDTO> selectiveCoursesFirstSemester;
    private List<SelectiveCourseDTO> selectiveCoursesSecondSemester;
}
