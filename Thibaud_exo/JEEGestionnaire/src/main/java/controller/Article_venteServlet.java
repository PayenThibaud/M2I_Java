package controller;

import entity.Article_vente;
import entity.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ArticleRepository;
import repository.Article_venteRepository;
import repository.ClientRepository;
import repository.VenteRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/articleVente")
public class Article_venteServlet extends HttpServlet {

    private List<Article_vente> articleVentes = new ArrayList<Article_vente>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article_venteRepository articleVenteRepository = new Article_venteRepository();
        articleVentes = articleVenteRepository.findAll();
        req.setAttribute("articleVentes", articleVentes);
        req.getRequestDispatcher("/WEB-INF/articleVente.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VenteRepository venteRepository = new VenteRepository();
        Article_venteRepository articleVenteRepository = new Article_venteRepository();
        ArticleRepository articleRepository = new ArticleRepository();

        Article_vente articleVente = Article_vente.builder()
                .vente(venteRepository.findById(Integer.parseInt(req.getParameter("vente"))))
                .article(articleRepository.findById(Integer.parseInt(req.getParameter("article"))))
                .quantiteArticle(Integer.parseInt(req.getParameter("quantiteArticle")))
                .build();


        articleVenteRepository.createOrUpdate(articleVente);

        resp.sendRedirect(req.getContextPath() + "/articleVente");
    }
}
