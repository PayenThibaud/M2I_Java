package controller;

import entity.Cat;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class CatServlet extends HttpServlet {

    private List<Cat> cats;

    public void init(){
        cats = new ArrayList<>();
//        cats.add(new Cat("Garfield","chat roux","lasagne",LocalDate.now()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cats",cats);
        req.getRequestDispatcher("/WEB-INF/cat.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat = Cat.builder()
                .name(req.getParameter("name"))
                .breed(req.getParameter("breed"))
                .favMeal(req.getParameter("favMeal"))
                .dateOfBirth(LocalDate.parse(req.getParameter("dateOfBirth")))
                .build();

        cats.add(cat);
        doGet(req,resp);
    }
}
