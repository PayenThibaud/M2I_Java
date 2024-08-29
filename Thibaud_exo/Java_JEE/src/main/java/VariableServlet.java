import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "variableServlet", value = "/Variables")
public class VariableServlet extends HttpServlet {

    private String test;
    private String nom;
    private List<String> listPrenom;

    public void init(){
        test = "toto";
        nom = "tata";
        listPrenom = new ArrayList<>();
        listPrenom.add("prenom1");
        listPrenom.add("prenom2");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("variable1",test);
        req.setAttribute("nom",nom);
        req.setAttribute("prenoms",listPrenom);
        getServletContext().getRequestDispatcher("/variable.jsp").forward(req,resp);
    }
}