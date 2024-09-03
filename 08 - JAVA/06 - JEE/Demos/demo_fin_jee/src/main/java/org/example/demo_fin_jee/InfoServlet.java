package org.example.demo_fin_jee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/infos")
public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/");
        String servletPath = req.getServletPath();
        String contextPath = req.getContextPath();
        String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+contextPath;

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> getServletContext().getRealPath(\"/\") : " + path + "</h1>");
        out.println("<h2> req.getServletPath() : " + servletPath + "</h2>");
        out.println("<h2> req.getContextPath() : " + contextPath + "</h2>");
        out.println("<h2>" + url + "</h2>");
        out.println("<a href=" + url + ">Mon application</a>");
        out.println("</body></html>");
    }
}
