package ua.edu.chdtu.deanoffice.mobile.backend.application.generateApplication;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.chdtu.deanoffice.mobile.backend.application.GeneratedApplication;
import ua.edu.chdtu.deanoffice.mobile.backend.application.dataForApplication.RenewApplicationData;
import ua.edu.chdtu.deanoffice.mobile.backend.application.dataForApplication.RetakeExamApplicationData;
import ua.edu.chdtu.deanoffice.mobile.backend.application.Parameters;
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
        Application application = applicationRepository.findById(parameters.applicationType).get();
        if(parameters.applicationType == 2) {
            RetakeExamApplicationData retakeExamApplicationData = new Gson().fromJson(parameters.json, RetakeExamApplicationData.class);
            generatedApplication.setHeader(buildHeader(application.getHeaders()));
            generatedApplication.setBody(buildBody(application.getBody(), retakeExamApplicationData.getKnowledgeControl(), retakeExamApplicationData.getCourse()));
        }
        else if(parameters.applicationType == 7) {
            RenewApplicationData renewApplicationData = new Gson().fromJson(parameters.json, RenewApplicationData.class);
            generatedApplication.setHeader(buildHeader8(application.getHeaders()));
            generatedApplication.setBody(buildBody7(application.getBody(), renewApplicationData.getDate()));
        }
        else if(parameters.applicationType == 8) {
            RenewApplicationData renewApplicationData = new Gson().fromJson(parameters.json, RenewApplicationData.class);
            generatedApplication.setHeader(buildHeader8(application.getHeaders()));
            generatedApplication.setBody(buildBody8(application.getBody(), renewApplicationData.getDate()));
        }
        return generatedApplication;
    }

    public String buildHeader(String headerTemplate) {
        StudentDegree studentDegree = studentDegreeRepository.findById(1).get();
        headerTemplate = headerTemplate.replace("#faculty_abbr", studentDegree.getSpecialization().getFaculty().getAbbr());
        headerTemplate = headerTemplate.replace("#dean_name", studentDegree.getSpecialization().getFaculty().getDeanName());
        headerTemplate = headerTemplate.replace("#student", studentDegree.getStudent().getSex()!="male"?"студента":"студентки");
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

    public String buildHeader8(String headerTemplate){
        StudentDegree studentDegree = studentDegreeRepository.findById(1).get();
        headerTemplate = headerTemplate.replace("#student", studentDegree.getStudent().getSex()!="male"?"студента":"студентки");
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

    public String buildBody(String bodyTemplate, int knowledgeControl, String course) {
        StudentDegree studentDegree = studentDegreeRepository.findById(1).get();
        bodyTemplate = bodyTemplate.replace("#knowledge_control", knowledgeControl==0?"іспиту":"заліку");
        bodyTemplate = bodyTemplate.replace("#course", course);
        bodyTemplate = bodyTemplate.replace("#degree", studentDegree.getSpecialization().getDegree().getName());
        return bodyTemplate;
    }

    public String buildBody7(String bodyTemplate, String date) {
        bodyTemplate = bodyTemplate.replace("#date", date);
        return bodyTemplate;
    }

    public String buildBody8(String bodyTemplate, String date) {
        StudentDegree studentDegree = studentDegreeRepository.findById(1).get();
        bodyTemplate = bodyTemplate.replace("#year", "1");
        bodyTemplate = bodyTemplate.replace("#degree", studentDegree.getSpecialization().getDegree().getName());
        bodyTemplate = bodyTemplate.replace("#date", date);
        return bodyTemplate;
    }
}
