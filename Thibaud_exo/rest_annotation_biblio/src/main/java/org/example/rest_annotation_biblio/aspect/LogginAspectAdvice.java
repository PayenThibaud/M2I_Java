package org.example.rest_annotation_biblio.aspect;

import org.aspectj.lang.JoinPoint;
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
    public void before(JoinPoint joinPoint) {
        System.out.println("Avant l execution de " + joinPoint.getSignature().getDeclaringTypeName() + " sur " + joinPoint.getSignature().getName());
    }




}
