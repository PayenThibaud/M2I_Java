package org.example.demoaop.controller;

import org.example.demoaop.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public void useMethode (){
        demoService.method();
    }

    @GetMapping("return")
    public void returning(){
        demoService.methodWithResult();
    }

    @GetMapping("throws")
    public void throwsReturn (){
        try{
            demoService.methodThrow();
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

    }
}
