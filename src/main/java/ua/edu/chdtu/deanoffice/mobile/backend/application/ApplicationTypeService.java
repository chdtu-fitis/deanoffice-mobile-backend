package ua.edu.chdtu.deanoffice.mobile.backend.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationType;

import java.util.List;

@Service
public class ApplicationTypeService {
    private ApplicationTypeRepository applicationRepository;

    @Autowired
    public ApplicationTypeService(ApplicationTypeRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<ApplicationType> getApplication() {
        List<ApplicationType> application = applicationRepository.getApplication();
        return application;
    }
}
