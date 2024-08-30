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

@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {
    private ChienRepository chienRepository;
    private String titre;
    public void init(){
        titre = "🐶ajouter des chiens 🐶";
        chienRepository = new ChienRepository();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("titre", titre);
        req.setAttribute("chien",new Chien());
        getServletContext().getRequestDispatcher("/WEB-INF/ajouter.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id = req.getParameter("id");
        Chien chien;
        if(id != null){
            int idint = Integer.parseInt(id);
            chien = chienRepository.findById(idint);
            chien.setNomChien(req.getParameter("nom"));
            chien.setRace(req.getParameter("race"));
            chien.setDateNaissance(LocalDate.parse(req.getParameter("dateDeNaissance")));

        }else{
            chien = Chien.builder()
                    .nomChien(req.getParameter("nom"))
                    .race(req.getParameter("race"))
                    .dateNaissance(LocalDate.parse(req.getParameter("dateDeNaissance")))
                    .build();
        }
        chienRepository.createOrUpdate(chien);
        doGet(req, resp);
    }
}
