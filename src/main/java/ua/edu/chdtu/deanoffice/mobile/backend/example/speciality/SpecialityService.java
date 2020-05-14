package ua.edu.chdtu.deanoffice.mobile.backend.example.speciality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.Speciality;

@Service
public class SpecialityService {
    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    public Speciality getSpecialityByCode(String code) {
        return specialityRepository.getSpecialityByCode(code);
    }
}
