package org.example.demo_jstl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> prenoms = new ArrayList<>();
        prenoms.add("toto");
        prenoms.add("tata");
        prenoms.add("titi");
        req.setAttribute("prenoms",prenoms);
        req.setAttribute("isTrue",true);
        req.setAttribute("isFalse",false);
        req.setAttribute("nameDemo","ma super demo !!!");
        req.getRequestDispatcher("/variable.jsp").forward(req,resp);

    }
}
