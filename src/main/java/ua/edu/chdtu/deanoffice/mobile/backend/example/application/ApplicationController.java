package ua.edu.chdtu.deanoffice.mobile.backend.example.application;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationType;

import java.util.List;

@Controller
public class ApplicationController {
    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/application")
    public ResponseEntity<List<ApplicationType>> getApplications() {
        List<ApplicationType> application = applicationService.getApplication();
        return ResponseEntity.ok(application);
    }
}
