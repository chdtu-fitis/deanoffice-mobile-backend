package ua.edu.chdtu.deanoffice.mobile.backend.selective.dto;

import lombok.Getter;
import lombok.Setter;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.superclasses.TypeCycle;
import ua.edu.chdtu.deanoffice.mobile.backend.student.dto.NamedDTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
public class SelectiveCoursesDTO {
    private Integer id;
    private boolean available;
    private CourseDTO course;
    private TeacherDTO teacher;
    private NamedDTO degree;
    private DepartmentDTO department;
    private List<NamedDTO> fieldsOfKnowledge;
    @Enumerated(EnumType.STRING)
    private TypeCycle trainingCycle;
    private String description;
    private Integer studyYear;
}
