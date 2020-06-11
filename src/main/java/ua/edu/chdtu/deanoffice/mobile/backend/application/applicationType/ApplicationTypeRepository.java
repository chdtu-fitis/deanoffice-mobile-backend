package ua.edu.chdtu.deanoffice.mobile.backend.application.applicationType;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationType;

public interface ApplicationTypeRepository extends JpaRepository<ApplicationType, Integer> {
}
