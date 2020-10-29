package ua.edu.chdtu.deanoffice.mobile.backend.selective;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.selective.dto.SelectiveCoursesDTO;

import java.util.List;

@Getter
@Setter
public class SelectiveCourses {
    private List<SelectiveCoursesDTO> selectiveCoursesFirstSemester;
    private List<SelectiveCoursesDTO> selectiveCoursesSecondSemester;
}
