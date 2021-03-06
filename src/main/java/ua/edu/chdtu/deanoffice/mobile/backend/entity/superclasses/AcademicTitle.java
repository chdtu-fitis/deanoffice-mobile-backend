package ua.edu.chdtu.deanoffice.mobile.backend.entity.superclasses;

public enum AcademicTitle {
    PROFESSOR("Професор", "Professor"),
    DOZENT("Доцент", "Associate Professor");

    private final String nameUkr;
    private final String nameEng;

    AcademicTitle(String nameUkr, String nameEng) {
        this.nameUkr = nameUkr;
        this.nameEng = nameEng;
    }
}
