package controller;

import entity.*;
import enums.Categorie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ArticleRepository;
import repository.ClientRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
    private List<Client> clients = new ArrayList<Client>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientRepository clientRepository = new ClientRepository();
        clients = clientRepository.findAll();
        req.setAttribute("clients", clients);
        req.getRequestDispatcher("/WEB-INF/client.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientRepository clientRepository = new ClientRepository();

                Client client = Client.builder()
                        .nom(req.getParameter("nom"))
                        .mail(req.getParameter("mail"))
                        .build();


        clientRepository.createOrUpdate(client);

        resp.sendRedirect(req.getContextPath() + "/client");
    }
}
