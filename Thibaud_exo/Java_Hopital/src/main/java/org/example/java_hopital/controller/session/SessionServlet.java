package org.example.java_hopital.controller.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/get-session/*")
public class SessionServlet extends HttpServlet {

    private static final String pseudo = "Titi";
    private static final String mdp = "123";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        switch (pathInfo) {
            case "connexion":
                req.getRequestDispatcher("/WEB-INF/Connexion/connexion.jsp").forward(req, resp);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String motsDePasse = req.getParameter("motsDePasse");

        if (pseudo.equals(user) && mdp.equals(motsDePasse)) {
            HttpSession session = req.getSession();
            session.setAttribute("logged", true);
            resp.sendRedirect(req.getContextPath() + "/patient/list");
        } else {
            req.setAttribute("error", "Nom d'utilisateur ou mot de passe invalide.");
            req.getRequestDispatcher("/WEB-INF/Connexion/connexion.jsp").forward(req, resp);
        }
    }
}

