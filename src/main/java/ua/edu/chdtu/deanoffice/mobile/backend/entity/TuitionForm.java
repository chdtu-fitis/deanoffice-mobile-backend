package ua.edu.chdtu.deanoffice.mobile.backend.entity;

public enum TuitionForm {
    FULL_TIME("Денна"),
    EXTRAMURAL("Заочна");

    private final String nameUkr;

    TuitionForm(String nameUkr) {
        this.nameUkr = nameUkr;
    }

    public String getNameUkr() {
        return nameUkr;
    }
}

