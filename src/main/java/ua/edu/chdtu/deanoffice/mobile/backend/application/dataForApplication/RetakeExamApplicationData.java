package ua.edu.chdtu.deanoffice.mobile.backend.application.dataForApplication;

public class RetakeExamApplicationData {
    private String course;
    private byte knowledge_control;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public byte getKnowledge_control() {
        return knowledge_control;
    }

    public void setKnowledge_control(byte knowledge_control) {
        this.knowledge_control = knowledge_control;
    }
}
