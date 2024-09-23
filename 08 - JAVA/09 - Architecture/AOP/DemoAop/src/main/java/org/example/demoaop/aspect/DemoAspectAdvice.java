package org.example.demoaop.aspect;

import jdk.swing.interop.SwingInterOpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspectAdvice {

    // @Before permet l'execution avant chaque execution de methode dans le dossier / classe / methode specifié
//    @Before("execution(* org.example.demoaop.service.*.*(..))")
//    public  void addBeforeEachServiceMethode(){
//        System.out.println("run before each method");
//    }

    //@After permet l'execution de la methode apres la fin de l'execution de la methode specifié
//    @After("execution(* org.example.demoaop.service.*.*(..))")
//    public void addAfterEachServiceMethods(){
//        System.out.println("run after each method");
//    }

    //@AfterReturning permet l'execution de la methode apres que la methode specifié a effectué son retour
//    @AfterReturning(value = "execution(* org.example.demoaop.service.DemoService.methodWithResult(..))",returning = "result")
//    public void addAfterReturningEachServicesMethod(Object result){
//        System.out.println("run after returning each method "+result);
//    }

    //@AfterThrowing permet l'execution de la methode apres que la methode specifié et levé une exception
//    @AfterThrowing("execution(*  org.example.demoaop.service.*.*(..))")
//    public void addAfterThrowingServiceMethod (){
//        System.out.println("run after throwing each method");
//    }

    //pointCut permet de definir un annotation comme un point d'entrée pour nos different advice que l'on pourras definir par la suite
    @Pointcut("@annotation(org.example.demoaop.annotation.DemoAspectAnnotation)")
    public void customPointCut() {

    }

    @Before("customPointCut()")
    public void beforePointCut (JoinPoint joinPoint){
        joinPoint.getSignature().getName();
        System.out.println("before execution ");
    }

    // @Arround permet d'executer notre methode avant l'execution de la methode/ de lancer l'execution
    // de la methode et d'executer encore des action apres l'execution de la méthode ciblé
    @Around("customPointCut()")
    public Object around (ProceedingJoinPoint proceedingJoinPoint){
        try{
            System.out.println("around cut");
            //recuperer nos arguments
            Object[] args = proceedingJoinPoint.getArgs();
            System.out.println(args);
            //demarer la methode avec proceed
            Object result = proceedingJoinPoint.proceed();
            return result;
        }catch (Exception ex){
            System.out.println("catch exception");
        }catch (Throwable e){
            throw new RuntimeException(e);
        }finally {
            return null;
        }
    }
}
