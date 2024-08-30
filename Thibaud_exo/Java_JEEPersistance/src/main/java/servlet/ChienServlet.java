package servlet;

import entity.Chien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ChienRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chien")
public class ChienServlet extends HttpServlet {
    private List<Chien> chiens = new ArrayList<Chien>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("chiens", chiens);
        req.getRequestDispatcher("/WEB-INF/chien.jsp").forward(req,resp);
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

        doGet(req,resp);
    }
}
