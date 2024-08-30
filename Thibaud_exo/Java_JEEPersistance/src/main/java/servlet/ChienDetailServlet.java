package servlet;

import entity.Chien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ChienRepository;

import java.io.IOException;

@WebServlet("/chienDetail")
public class ChienDetailServlet extends HttpServlet {

    private ChienRepository chienRepository;

    @Override
    public void init() {
        this.chienRepository = new ChienRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        int id = Integer.parseInt(idParam);

        Chien chien = chienRepository.findById(id);

        req.setAttribute("chien", chien);

        req.getRequestDispatcher("/WEB-INF/chienDetail.jsp").forward(req, resp);
    }
}
