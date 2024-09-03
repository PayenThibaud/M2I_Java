package org.example.demo_fin_jee.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/have-cookies")
public class CheckCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        boolean logged = false;

        Cookie[] cookies = req.getCookies();

        for (Cookie c: cookies){
            if(c.getName().equals("isLogged") && c.getValue().equals("true")){
                out.println("<h1>Connecte !!!!</h1>");
                logged = true;
                break;
            }
        }

        if(!logged){
            out.println("<h1>Pas Connecte !!!!</h1>");
        }

        out.println("<h2> vous avez "+cookies.length+"</h2>");

        out.println("</body></html>");
    }
}
