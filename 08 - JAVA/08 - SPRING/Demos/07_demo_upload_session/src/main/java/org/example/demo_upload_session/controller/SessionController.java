package org.example.demo_upload_session.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller
@ResponseBody
public class SessionController {

    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/ecrire")
    public void ecrire(){
        httpSession.setAttribute("name", "toto");
        httpSession.setAttribute("list", Arrays.asList("titi", "toto", "tata"));
    }

    @RequestMapping("/lire")
    public void lire(){
        httpSession.getAttribute("name").toString();
    }

    @RequestMapping("/delete")
    public void supprimer(){
        httpSession.removeAttribute("name");
    }
}
