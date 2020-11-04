package ua.edu.chdtu.deanoffice.mobile.backend.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
