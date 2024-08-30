package controller;

import entity.Client;
import entity.Vente;
import enums.Categorie;
import enums.Status;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ClientRepository;
import repository.VenteRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/vente")
public class VenteServlet extends HttpServlet {
    private List<Vente> ventes = new ArrayList<Vente>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VenteRepository venteRepository = new VenteRepository();
        ventes = venteRepository.findAll();
        req.setAttribute("ventes", ventes);
        req.getRequestDispatcher("/WEB-INF/vente.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VenteRepository venteRepository = new VenteRepository();
        ClientRepository clientRepository = new ClientRepository();

        Vente vente = Vente.builder()
                .date(req.getParameter("date"))
                .status(Status.valueOf(req.getParameter("status")))
                .client(clientRepository.findById(Integer.parseInt(req.getParameter("client"))))
                .build();


        venteRepository.createOrUpdate(vente);

        resp.sendRedirect(req.getContextPath() + "/vente");
    }
}
