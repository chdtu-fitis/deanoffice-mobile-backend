package ua.edu.chdtu.deanoffice.mobile.backend.example.speciality;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.Speciality;

@RestController
public class SpecialityController {
    private SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping("/speciality")
    public ResponseEntity<Speciality> getSpecialities() {
        Speciality speciality = specialityService.getSpecialityByCode("121");
        return ResponseEntity.ok(speciality);
    }
}
