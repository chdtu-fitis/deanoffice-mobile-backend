package ua.edu.chdtu.deanoffice.mobile.backend.application;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.StudentDegree;

public interface StudentDegreeRepository extends JpaRepository<StudentDegree, Integer> {
}
