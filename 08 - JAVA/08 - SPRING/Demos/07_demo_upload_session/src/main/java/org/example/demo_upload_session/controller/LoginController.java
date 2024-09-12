package org.example.demo_upload_session.controller;

import org.example.demo_upload_session.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/login")
    public String loginForm(){
        return "form";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        if (loginService.login(username, password)){
            return "protected";
        }
        return "redirect:/login";
    }

    @RequestMapping("/protected")
    public String protectedPage(){
        if (loginService.isLogged()){
            return "protected";
        }
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout(){
        loginService.logout();
        return "redirect:/login";
    }
}
