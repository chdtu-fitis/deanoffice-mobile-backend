package ua.edu.chdtu.deanoffice.mobile.backend.application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parameters {
    private String json;
    private int applicationType;

    public Parameters(String json, int applicationType) {
        this.json = json;
        this.applicationType = applicationType;
    }
}
