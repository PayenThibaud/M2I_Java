package org.example.demo_routing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "multirouteservlet", value = {"/multi-routes","/multi/*"})
public class MultiRouteServlet extends HttpServlet {

    private List<String> prenoms;

    @Override
    public void init() throws ServletException {
        prenoms = new ArrayList<>();
        prenoms.add("Toto");
        prenoms.add("Tata");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recupere le pathinfo avec le /
       // String pathInfo = req.getPathInfo();
       // System.out.println(pathInfo);

        // Verification que le pathinfo a bien des informations
        // Type maVariable = (test_conditionnel1 && || test_conbditionnel2) ? "resultat si vrai" : "resultat si faux"
        String pathInfo = (req.getPathInfo() != null && !req.getPathInfo().isEmpty()) ? req.getPathInfo() : "";

        String searchName = "";

        // si j'ai autre chose que "" dans mon pathinfpo alors je vais aller recup la presonne correspondante
        if(!pathInfo.isEmpty()){
            System.out.println("Path info obtenue : "+pathInfo);
            // methode .substring(1) pour enlever le premier caractere
            System.out.println("Path info sans le / au debut : "+pathInfo.substring(1));
            // Integer parseInt pour transformer la chaine de caractere en numero
            System.out.println("pathinfo en integer a partir du string : "+Integer.parseInt(pathInfo.substring(1)));
            searchName = prenoms.get(Integer.parseInt(pathInfo.substring(1)));
            System.out.println(searchName);
        }





        req.getRequestDispatcher("/multi.jsp").forward(req,resp);
    }
}
