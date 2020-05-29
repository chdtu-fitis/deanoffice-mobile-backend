package ua.edu.chdtu.deanoffice.mobile.backend.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.ApplicationType;

import java.util.List;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<ApplicationType> getApplication() {
        List<ApplicationType> application = applicationRepository.getApplication();
        return application;
    }

}
