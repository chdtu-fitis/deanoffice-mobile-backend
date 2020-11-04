package ua.edu.chdtu.deanoffice.mobile.backend.application;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.Application;
import ua.edu.chdtu.deanoffice.mobile.backend.entity.StudentDegree;

@Service
public class GenerateAppliсationService {
    private StudentDegreeRepository studentDegreeRepository;
    private ApplicationRepository applicationRepository;

    @Autowired
    public GenerateAppliсationService(StudentDegreeRepository studentDegreeRepository, ApplicationRepository applicationRepository) {
        this.studentDegreeRepository = studentDegreeRepository;
        this.applicationRepository = applicationRepository;
    }

    public GeneratedApplication createApplication(Parameters parameters) {
        GeneratedApplication generatedApplication = new GeneratedApplication();
        Application application = applicationRepository.findById(parameters.getApplicationType()).get();
        switch (parameters.getApplicationType()) {
            case 2:
                RetakeExamApplicationData retakeExamApplicationData = new Gson().fromJson(parameters.getJson(), RetakeExamApplicationData.class);
                generatedApplication.setHeader(buildHeaderForDeanApplication(application.getHeader()));
                generatedApplication.setBody(buildBodyForRetakeExamApplication(application.getBody(), retakeExamApplicationData.getKnowledgeControl(), retakeExamApplicationData.getCourse()));
                break;
            case 7:
                RenewApplicationData renewApplicationData = new Gson().fromJson(parameters.getJson(), RenewApplicationData.class);
                generatedApplication.setHeader(buildHeaderForRectorApplication(application.getHeader()));
                generatedApplication.setBody(buildBodyForRenewApplication(application.getBody(), renewApplicationData.getDate()));
                break;
            case 8:
                RenewApplicationData deductionApplicationData = new Gson().fromJson(parameters.getJson(), RenewApplicationData.class);
                generatedApplication.setHeader(buildHeaderForRectorApplication(application.getHeader()));
                generatedApplication.setBody(buildBodyForDeductionApplication(application.getBody(), deductionApplicationData.getDate()));
                break;
        }
        return generatedApplication;
    }

    public String buildHeaderForDeanApplication(String headerTemplate) {
        StudentDegree studentDegree = studentDegreeRepository.findById(1).get();
        headerTemplate = headerTemplate.replace("#faculty_abbr", studentDegree.getSpecialization().getFaculty().getAbbr());
        headerTemplate = headerTemplate.replace("#dean_name", studentDegree.getSpecialization().getFaculty().getDeanName());
        headerTemplate = buildBaseHeader(headerTemplate);
        return headerTemplate;
    }

    public String buildHeaderForRectorApplication(String headerTemplate) {
        StudentDegree studentDegree = studentDegreeRepository.findById(1).get();
        headerTemplate = headerTemplate.replace("#student", studentDegree.getStudent().getSex() != "male" ? "студента" : "студентки");
        headerTemplate = headerTemplate.replace("#year", "1");
        headerTemplate = buildBaseHeader(headerTemplate);
        return headerTemplate;
    }

    public String buildBodyForRetakeExamApplication(String bodyTemplate, int knowledgeControl, String course) {
        StudentDegree studentDegree = studentDegreeRepository.findById(1).get();
        bodyTemplate = bodyTemplate.replace("#knowledge_control", knowledgeControl == 0 ? "іспиту" : "заліку");
        bodyTemplate = bodyTemplate.replace("#course", course);
        bodyTemplate = bodyTemplate.replace("#degree", studentDegree.getSpecialization().getDegree().getName());
        return bodyTemplate;
    }

    public String buildBodyForRenewApplication(String bodyTemplate, String date) {
        bodyTemplate = bodyTemplate.replace("#date", date);
        return bodyTemplate;
    }

    public String buildBodyForDeductionApplication(String bodyTemplate, String date) {
        StudentDegree studentDegree = studentDegreeRepository.findById(1).get();
        bodyTemplate = bodyTemplate.replace("#year", "1");
        bodyTemplate = bodyTemplate.replace("#degree", studentDegree.getSpecialization().getDegree().getName());
        bodyTemplate = bodyTemplate.replace("#date", date);
        return bodyTemplate;
    }

    public String buildBaseHeader(String headerTemplate) {
        StudentDegree studentDegree = studentDegreeRepository.findById(1).get();
        headerTemplate = headerTemplate.replace("#student", studentDegree.getStudent().getSex() != "male" ? "студента" : "студентки");
        headerTemplate = headerTemplate.replace("#year", "1");
        headerTemplate = headerTemplate.replace("#degree", studentDegree.getSpecialization().getDegree().getName());
        headerTemplate = headerTemplate.replace("#tution_form", studentDegree.getTuitionForm());
        headerTemplate = headerTemplate.replace("#speciality_name", studentDegree.getSpecialization().getSpeciality().getName());
        headerTemplate = headerTemplate.replace("#specialization_name", studentDegree.getSpecialization().getName());
        headerTemplate = headerTemplate.replace("#group_name", studentDegree.getStudentGroup().getName());
        headerTemplate = headerTemplate.replace("#payment", studentDegree.getPayment());
        headerTemplate = headerTemplate.replace("#surname", studentDegree.getStudent().getSurname());
        headerTemplate = headerTemplate.replace("#name", studentDegree.getStudent().getName());
        headerTemplate = headerTemplate.replace("#patronimic", studentDegree.getStudent().getPatronimic());
        headerTemplate = headerTemplate.replace("#telephone", "+380973452185");
        return headerTemplate;
    }
}
