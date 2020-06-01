package ua.edu.chdtu.deanoffice.mobile.backend.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationType;

import java.util.List;

public interface ApplicationTypeRepository extends JpaRepository<ApplicationType, Integer> {
    @Query("SELECT a FROM ApplicationType a")
    List<ApplicationType> getApplication();
}
