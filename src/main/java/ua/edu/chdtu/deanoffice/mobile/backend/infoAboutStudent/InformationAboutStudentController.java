package ua.edu.chdtu.deanoffice.mobile.backend.infoAboutStudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.chdtu.deanoffice.mobile.backend.infoAboutStudent.dto.StudentDTO;

import static ua.edu.chdtu.deanoffice.mobile.backend.general.mapper.Mapper.map;

@RestController
public class InformationAboutStudentController {
    private InformationAboutStudentService restService;

    @Autowired
    public InformationAboutStudentController(InformationAboutStudentService restService) {
        this.restService = restService;
    }

    @GetMapping("/info-about-student")
    public ResponseEntity getInfoAboutStudent() {
        return ResponseEntity.ok(map(restService.getStudentInfo(), StudentDTO.class));
    }
}
