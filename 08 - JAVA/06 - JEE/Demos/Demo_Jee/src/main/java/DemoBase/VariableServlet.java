package DemoBase;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "variableServlet", value = "/variables")
public class VariableServlet extends HttpServlet {

    private String prenom;
    private String nom;
    private List<String> listPrenom;

    public void init(){
        prenom = "toto";
        nom = "tata";
        listPrenom = new ArrayList<>();
        listPrenom.add("prenom1");
        listPrenom.add("prenom2");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("nom",nom);
        req.setAttribute("prenom",prenom);
        req.setAttribute("prenoms",listPrenom);
        req.getRequestDispatcher("/variable.jsp").forward(req,resp);
    }
}
