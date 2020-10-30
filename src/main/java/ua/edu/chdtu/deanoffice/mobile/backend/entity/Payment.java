package ua.edu.chdtu.deanoffice.mobile.backend.entity;

public enum Payment {
    CONTRACT("Контракт"),
    BUDGET("Бюджет");

    private final String nameUkr;

    Payment(String nameUkr) {
        this.nameUkr = nameUkr;
    }

    public String getNameUkr() {
        return nameUkr;
    }
}
