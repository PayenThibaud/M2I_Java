package org.example.demo_fin_jee.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/get-cookies")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("isLogged","true");
        Cookie cookie1 = new Cookie("toto","tata");
        cookie1.setMaxAge(60*60); // duree en seconde
        resp.addCookie(cookie);
        resp.addCookie(cookie1);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>I give you a cookie !!!</h1>");
        out.println("</body></html>");
    }
}
