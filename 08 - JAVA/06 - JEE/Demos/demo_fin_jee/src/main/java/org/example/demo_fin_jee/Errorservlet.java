package org.example.demo_fin_jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/error")
public class Errorservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Division par 0 provoque une erreur 500
        // on ajoute au fichier web.xml une configuration afin de personalise cette exception (ArithmeticeException)
        int mynumber = 5/0;
    }
}
