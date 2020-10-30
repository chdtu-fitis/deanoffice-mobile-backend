package ua.edu.chdtu.deanoffice.mobile.backend.entity;

public enum TuitionTerm {
    REGULAR("Повна"),
    SHORTENED("Скорочена");

    private final String nameUkr;

    TuitionTerm(String nameUkr) {
        this.nameUkr = nameUkr;
    }

    public String getNameUkr() {
        return nameUkr;
    }
}
