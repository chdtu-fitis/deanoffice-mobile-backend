package ua.edu.chdtu.deanoffice.mobile.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentDegree {
    @Id
    private int id;
    private String payment;
    @ManyToOne
    private Specialization specialization;
    @ManyToOne
    private Student student;
    @ManyToOne
    private StudentGroup studentGroup;
    private String tuitionForm;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getTuitionForm() {
        return tuitionForm;
    }

    public void setTuitionForm(String tuitionForm) {
        this.tuitionForm = tuitionForm;
    }
}
