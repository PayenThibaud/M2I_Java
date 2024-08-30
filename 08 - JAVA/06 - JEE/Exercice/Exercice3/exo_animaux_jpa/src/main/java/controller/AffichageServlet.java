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
import java.util.List;

@WebServlet("/")
public class AffichageServlet extends HttpServlet {
    private ChienRepository chienRepository ;
    private List<Chien> chiensList;
    private String titre;

    public void init() {
        chienRepository = new ChienRepository();
        chiensList = chienRepository.findAll();
        this.titre = "🐶affichage de la liste des chien 🐶";
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chiensList = chienRepository.findAll();
        req.setAttribute("titre", titre);
        req.setAttribute("chiens", chiensList);
        getServletContext().getRequestDispatcher("/WEB-INF/affichage.jsp").forward(req, resp);
    }


}
