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
import java.time.Period;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private ChienRepository chienRepository;
    String titre ;

    @Override
    public void init() throws ServletException {
        chienRepository = new ChienRepository();
        titre = "🐶ajouter des chiens 🐶";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idChienParam = req.getParameter("idChien");
        if (idChienParam != null) {
            int idChien = Integer.parseInt(idChienParam);

            Chien chienTrouve = chienRepository.findById(idChien);
            if(chienTrouve != null){
                req.setAttribute("chien",chienTrouve);
                req.setAttribute("titre",titre);
                getServletContext().getRequestDispatcher("/WEB-INF/ajouter.jsp").forward(req, resp);
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/affichage.jsp").forward(req, resp);
    }

}
