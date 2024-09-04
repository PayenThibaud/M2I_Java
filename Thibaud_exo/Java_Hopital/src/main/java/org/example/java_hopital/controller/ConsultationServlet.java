package org.example.java_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.java_hopital.entity.Consultation;
import org.example.java_hopital.entity.Patient;
import org.example.java_hopital.repository.ConsultationRepository;
import org.example.java_hopital.repository.PatientRepository;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="consultationservlet", value = {"/consultation/*"})
public class ConsultationServlet extends HttpServlet {
    private ConsultationRepository consultationRepository;
    private PatientRepository patientRepository;

    @Override
    public void init() {
        this.consultationRepository = new ConsultationRepository();
        this.patientRepository = new PatientRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        switch (pathInfo) {
            case "list":
                AfficherTout(req, resp);
                break;
            case "addConsultation":
                AjouterConsultation(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void AfficherTout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int patientId = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("consultations", consultationRepository.getConsultationByPatient(patientId));
        req.setAttribute("patient", patientRepository.findById(patientId));
        req.getRequestDispatcher("/WEB-INF/Consultation/list.jsp").forward(req, resp);
    }

    protected void AjouterConsultation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int patientId = Integer.parseInt(req.getParameter("patientId"));
        Patient patient = patientRepository.findById(patientId);

        Consultation consultation = Consultation.builder()
                .nomMedecin(req.getParameter("nomMedecin"))
                .dateDeConsultation(LocalDate.parse(req.getParameter("dateDeConsultation")))
                .prescription(req.getParameter("prescription"))
                .ficheDeSoin(req.getParameter("ficheDeSoin"))
                .patient(patient)
                .build();

        consultationRepository.createOrUpdate(consultation);
        resp.sendRedirect(req.getContextPath() + "/consultation/list?id=" + patientId);
    }
}
