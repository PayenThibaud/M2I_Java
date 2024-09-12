package org.example.spring_exo_etudient.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class LoginService {

    @Autowired
    private HttpSession httpSession;

    private String Login = "admin";
    private String Password = "ad";

    public boolean login(String login, String password) {
        if (login.equals(Login) && password.equals(Password)) {
            httpSession.setAttribute("login", "OK");
            return true;
        }
        return false;
    }

    public boolean isLogged(){
        try {
            String isOK = httpSession.getAttribute("login").toString();
            return isOK.equals("OK");
        } catch (Exception e) {
            return false;
        }
    }

    public void logout(){
        httpSession.removeAttribute("login");
    }

}
