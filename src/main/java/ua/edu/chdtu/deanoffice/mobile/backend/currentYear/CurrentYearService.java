package ua.edu.chdtu.deanoffice.mobile.backend.currentYear;

import org.springframework.stereotype.Service;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.CurrentYear;

@Service
public class CurrentYearService {

    private CurrentYearRepository currentYearRepository;

    public CurrentYearService(CurrentYearRepository currentYearRepository) {
        this.currentYearRepository = currentYearRepository;
    }

    public CurrentYear get() {
        return currentYearRepository.getOne(1);
    }

    public int getYear() {
        return get().getCurrYear();
    }
}
