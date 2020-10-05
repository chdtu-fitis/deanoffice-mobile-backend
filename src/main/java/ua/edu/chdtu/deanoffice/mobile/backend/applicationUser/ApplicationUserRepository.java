package ua.edu.chdtu.deanoffice.mobile.backend.applicationUser;

import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {
    ApplicationUser findByUsername(String username);
}
