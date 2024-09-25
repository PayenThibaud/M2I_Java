package org.example.omq_gateway.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.omq_gateway.utils.PortApi;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.example.omq_gateway.tools.RestClient;



@Component
@Aspect
public class LoginAspect {
    @Before("execution(* org.example.omq_gateway.controller.logedController.*.*(..))")
    public void testToken() {
        RestClient<String> restClient = new RestClient<>("http://localhost:"+ PortApi.portAuth +"/api/test");
        HttpServletRequest servletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = servletRequest.getHeader("Authorization");
        if(!restClient.testToken(token, String.class)) {
            throw new RuntimeException();
        }
    }
}