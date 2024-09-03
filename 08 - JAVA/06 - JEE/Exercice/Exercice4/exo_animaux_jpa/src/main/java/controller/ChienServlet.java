package controller;

import entity.Chien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ChienRepository;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet(name = "dogServlet", value = "/dog/*")
public class ChienServlet extends HttpServlet {

    private ChienRepository chienRepository;

    @Override
    public void init() throws ServletException {
        chienRepository = new ChienRepository();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getPathInfo().substring(1);
        switch (action){
            case "list":
                // methode pour afficher la liste des chiens
                showAll(req,resp);
                break;
            case "addForm":
                // afficher la page avec le formulaire
                showForm(req,resp);
                break;
            case "add":
                // post d'un nouveau chien
                add(req,resp);
                break;
            case "detail":
                // methode pour afficher le detail d'un chien
                showDetails(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.setAttribute("chiens",chienRepository.findAll());
          req.getRequestDispatcher("/WEB-INF/dogs/list.jsp").forward(req,resp);
    }

    protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Chien chien = new Chien("","", LocalDate.now());
        req.setAttribute("dog",chien);
        // pour preciser que je suis en mode ajout de chien a ma page dogForm
        req.setAttribute("mode","add");
        req.getRequestDispatcher("/WEB-INF/dogs/dogForm.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        chienRepository.createOrUpdate(Chien.builder().nomChien(name).race(breed).dateNaissance(birthDate).build());
        resp.sendRedirect("list");
    }

    protected void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dogId = Integer.parseInt(req.getParameter("id"));
        Chien chien = chienRepository.findById(dogId);
        req.setAttribute("dog",chien);
        // je precise que je suis en mode view (visualise les donees d'un chien)
        req.setAttribute("mode","view");
        req.getRequestDispatcher("/WEB-INF/dogs/dogForm.jsp").forward(req,resp);
    }







}
