package org.example.demoaop.service;

import org.example.demoaop.annotation.DemoAspectAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @DemoAspectAnnotation
    public void method(){
        System.out.println("ma logique metier ... ");
    }

    public String methodWithResult (){
        return "result";
    }

    public void methodThrow (){
        throw new RuntimeException("exception throws");
    }
}
