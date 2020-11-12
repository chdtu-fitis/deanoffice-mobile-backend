package ua.edu.chdtu.deanoffice.mobile.backend.selective.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SelectiveCoursesStudentDegreeWriteDTO implements Serializable {
    private List<Integer> selectiveCourses;
    private int studentDegreeId;


}
