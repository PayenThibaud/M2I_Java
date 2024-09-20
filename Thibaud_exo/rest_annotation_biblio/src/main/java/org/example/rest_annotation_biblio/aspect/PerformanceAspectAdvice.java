package org.example.rest_annotation_biblio.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspectAdvice {

    @Pointcut("@annotation(org.example.rest_annotation_biblio.annotation.PerformanceAspect)")
    public void performanceAspect() {}

    @Around("performanceAspect()")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;
        System.out.println("Temps d'exécution de " + joinPoint.getSignature() + ": " + executionTime + " ms");

        return result;
    }
}
