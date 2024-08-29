import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.System.out;

@WebServlet(name = "textBrute",value = "/textBrute")
public class TexteBrutServlet extends HttpServlet {
    private String message;

    public void init () {message = "1er exo";}

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        out.println(message);
    }
}
