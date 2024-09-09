package org.example.demo_fragments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/")
    public String homePage(){
        return "pagea";
    }

    @RequestMapping("/pageb")
    public String pageb(){
        return "pageb";
    }
}
