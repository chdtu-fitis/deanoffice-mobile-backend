package ua.edu.chdtu.deanoffice.mobile.backend.application.applicationType;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.edu.chdtu.deanoffice.mobile.backend.dto.ApplicationTypeDTO;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationType;

import java.util.List;

import static ua.edu.chdtu.deanoffice.mobile.backend.general.mapper.Mapper.map;

@Controller
public class ApplicationTypeController {
    private ApplicationTypeService applicationTypeService;

    public ApplicationTypeController(ApplicationTypeService applicationTypeService) {
        this.applicationTypeService = applicationTypeService;
    }

    @GetMapping("/application-type")
    public ResponseEntity<List<ApplicationTypeDTO>> getApplicationTypes() {
        List<ApplicationType> applicationTypes = applicationTypeService.getApplicationTypes();
        return ResponseEntity.ok(map(applicationTypes, ApplicationTypeDTO.class));
    }
}
