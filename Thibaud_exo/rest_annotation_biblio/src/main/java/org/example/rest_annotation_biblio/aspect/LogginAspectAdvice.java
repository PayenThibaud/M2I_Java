package org.example.rest_annotation_biblio.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogginAspectAdvice {

    @Pointcut("@annotation(org.example.rest_annotation_biblio.annotation.LogginAspect)")
    public void logginAspect() {}

    @Before("logginAspect()")
    public void before() {
        System.out.println("Avant l execution");
    }




}
