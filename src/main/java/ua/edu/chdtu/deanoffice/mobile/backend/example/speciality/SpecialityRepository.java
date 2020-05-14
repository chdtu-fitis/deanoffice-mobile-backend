package ua.edu.chdtu.deanoffice.mobile.backend.example.speciality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
    @Query("SELECT s from Speciality s " +
            "where s.code = :code ")
    Speciality getSpecialityByCode(@Param("code") String code);
}
