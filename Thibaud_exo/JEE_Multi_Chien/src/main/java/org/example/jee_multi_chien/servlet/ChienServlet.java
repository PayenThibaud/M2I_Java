package org.example.jee_multi_chien.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jee_multi_chien.entity.Chien;
import org.example.jee_multi_chien.repository.ChienRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "chienservlet", value = {"/chien/*"})
public class ChienServlet extends HttpServlet {

    private ChienRepository chienRepository;

    @Override
    public void init() {
        this.chienRepository = new ChienRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("chiens", chienRepository.findAll());

        String pathInfo = req.getPathInfo().substring(1);
        switch (pathInfo) {
            case "list":
                AfficherTout(req, resp);
                break;
            case "add":
                Ajout(req, resp);
                break;
            case "addForm":
                AfficherAjout(req, resp);
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

    protected void Ajout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        chienRepository.createOrUpdate(Chien.builder()
                .nom(req.getParameter("nom"))
                .race(req.getParameter("race"))
                .dateDeNaissance(LocalDate.parse(req.getParameter("dateDeNaissance")))
                .build());

        resp.sendRedirect("list");
    }

    protected void AfficherTout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("chiens", chienRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
    }

    protected void AfficherAjout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Chien chien = Chien.builder()
                .nom("")
                .race("")
                .dateDeNaissance(LocalDate.now())
                .build();
        req.setAttribute("chien", chien);
        req.setAttribute("mode", "add");
        req.getRequestDispatcher("/WEB-INF/chienForm.jsp").forward(req, resp);
    }

    protected void AfficherDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int chienId = Integer.parseInt(req.getParameter("id"));
        Chien chien = chienRepository.findById(chienId);
        req.setAttribute("chien",chien);
        req.setAttribute("mode","view");
        req.getRequestDispatcher("/WEB-INF/chienForm.jsp").forward(req,resp);
    }
}
