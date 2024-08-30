package controller;

import entity.Article;
import entity.Article_Mode;
import entity.Article_Nourriture;
import entity.Article_electronique;
import enums.Categorie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ArticleRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
    private List<Article> articles = new ArrayList<Article>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleRepository articleRepository = new ArticleRepository();
        articles = articleRepository.findAll();
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/WEB-INF/article.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleRepository articleRepository = new ArticleRepository();

        String articleType = req.getParameter("type");
        Article article = null;

        switch (articleType) {
            case "nourriture":
                article = Article_Nourriture.builder()
                        .description(req.getParameter("description"))
                        .prix(Integer.parseInt(req.getParameter("prix")))
                        .quantite(Integer.parseInt(req.getParameter("quantite")))
                        .dateDeRestock(req.getParameter("dateDeRestock"))
                        .datePeremption(req.getParameter("datePeremption"))
                        .build();
                break;
            case "electronique":
                article = Article_electronique.builder()
                        .description(req.getParameter("description"))
                        .prix(Integer.parseInt(req.getParameter("prix")))
                        .quantite(Integer.parseInt(req.getParameter("quantite")))
                        .dateDeRestock(req.getParameter("dateDeRestock"))
                        .dureeBatterie(req.getParameter("dureeBatterie"))
                        .build();
                break;
            case "mode":
                article = Article_Mode.builder()
                        .description(req.getParameter("description"))
                        .prix(Integer.parseInt(req.getParameter("prix")))
                        .quantite(Integer.parseInt(req.getParameter("quantite")))
                        .dateDeRestock(req.getParameter("dateDeRestock"))
                        .categorie(Categorie.valueOf(req.getParameter("categorie")))
                        .taille(Integer.parseInt(req.getParameter("taille")))
                        .build();
                break;
            default:
                throw new IllegalArgumentException("Type d'article non supporté : " + articleType);
        }

        articleRepository.createOrUpdate(article);

        resp.sendRedirect(req.getContextPath() + "/article");
    }


}
