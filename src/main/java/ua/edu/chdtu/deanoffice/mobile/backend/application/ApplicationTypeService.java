package ua.edu.chdtu.deanoffice.mobile.backend.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationType;

import java.util.List;

@Service
public class ApplicationTypeService {
    private ApplicationTypeRepository applicationTypeRepository;

    @Autowired
    public ApplicationTypeService(ApplicationTypeRepository applicationTypeRepository) {
        this.applicationTypeRepository = applicationTypeRepository;
    }

    public List<ApplicationType> getApplicationType() {
        List<ApplicationType> application = applicationTypeRepository.getApplicationType();
        return application;
    }
}
