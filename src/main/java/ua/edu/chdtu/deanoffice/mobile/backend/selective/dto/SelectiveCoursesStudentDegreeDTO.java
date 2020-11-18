package ua.edu.chdtu.deanoffice.mobile.backend.selective.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SelectiveCoursesStudentDegreeDTO {
    private ExistingIdDTO studentDegree;
    private List<ExistingIdDTO> selectiveCourses;
}
