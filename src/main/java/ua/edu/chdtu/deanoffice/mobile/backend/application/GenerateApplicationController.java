package ua.edu.chdtu.deanoffice.mobile.backend.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateApplicationController {
    private GenerateAppliсationService generateApplicationService;

    public GenerateApplicationController(GenerateAppliсationService generateApplicationService) {
        this.generateApplicationService = generateApplicationService;
    }

    @GetMapping("/applications")
    public ResponseEntity getApplication(@RequestParam String json, @RequestParam int applicationType) {
        Parameters parameters = new Parameters(json, applicationType);
        return ResponseEntity.ok(generateApplicationService.createApplication(parameters));
    }
}



