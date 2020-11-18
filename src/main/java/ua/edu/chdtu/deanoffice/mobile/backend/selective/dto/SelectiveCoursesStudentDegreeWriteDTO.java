package ua.edu.chdtu.deanoffice.mobile.backend.selective.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class SelectiveCoursesStudentDegreeWriteDTO {
    @NotNull
    private List<Integer> selectiveCourses;
    @NotNull
    private ExistingIdDTO studentDegree;
}
