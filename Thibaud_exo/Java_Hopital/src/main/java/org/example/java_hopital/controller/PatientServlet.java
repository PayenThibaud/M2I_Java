package org.example.java_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.java_hopital.entity.Patient;
import org.example.java_hopital.repository.PatientRepository;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "patientservlet", value = {"/patient/*"})
public class PatientServlet extends HttpServlet {

    private PatientRepository patientRepository;

    @Override
    public void init() {
        this.patientRepository = new PatientRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("patients", patientRepository.findAll());

        String pathInfo = req.getPathInfo().substring(1);
        switch (pathInfo) {
            case "list":
                AfficherTout(req, resp);
                break;
            case "addPatient":
                Ajout(req, resp);
                break;
            case "detail":
                AfficherDetail(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void AfficherTout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("patients", patientRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/Patient/list.jsp").forward(req, resp);
    }

    protected void Ajout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        patientRepository.createOrUpdate(Patient.builder()
                .nom(req.getParameter("nom"))
                .prenom(req.getParameter("prenom"))
                .dateDeNaissance(LocalDate.parse(req.getParameter("dateDeNaissance")))
                .build());

        resp.sendRedirect("list");
    }


    protected void AfficherDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int patientId = Integer.parseInt(req.getParameter("id"));
        Patient patient = patientRepository.findById(patientId);
        req.setAttribute("patient", patient);
        req.getRequestDispatcher("/WEB-INF/Patient/detail.jsp").forward(req, resp);
    }
}