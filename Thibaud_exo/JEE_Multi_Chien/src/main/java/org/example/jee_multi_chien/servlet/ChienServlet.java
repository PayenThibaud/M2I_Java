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

        String pathInfo = req.getPathInfo();
        switch (pathInfo) {
            case "/list":
                req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
                break;
            case "/add":
                req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ChienRepository chienRepository = new ChienRepository();

        Chien chien = Chien.builder()
                .nom(req.getParameter("nom"))
                .race(req.getParameter("race"))
                .dateDeNaissance(LocalDate.parse(req.getParameter("dateDeNaissance")))
                .build();

        chienRepository.createOrUpdate(chien);

        doGet(req, resp);
    }
}
