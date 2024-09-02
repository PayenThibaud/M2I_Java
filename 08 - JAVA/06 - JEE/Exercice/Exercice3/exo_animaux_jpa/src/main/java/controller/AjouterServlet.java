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
        Chien newChien = new Chien();
        newChien.setIdChien(0);
        req.setAttribute("chien",newChien);
        getServletContext().getRequestDispatcher("/WEB-INF/ajouter.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("ajout d'un chien");

        String stringId = req.getParameter("id");
        int id = Integer.parseInt((stringId));
        System.out.println(id);
        Chien chien;

        if(id == 0){
            int idint = Integer.parseInt(stringId);
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
