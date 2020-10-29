package ua.edu.chdtu.deanoffice.mobile.backend.currentYear;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.CurrentYear;

public interface CurrentYearRepository extends JpaRepository<CurrentYear, Integer> {
}
