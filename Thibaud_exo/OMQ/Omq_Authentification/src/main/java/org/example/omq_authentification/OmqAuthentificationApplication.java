package org.example.omq_authentification;

import org.example.omq_authentification.security.JWTGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OmqAuthentificationApplication {


    public static void main(String[] args)  {
//        generator.generateToken("test");
        SpringApplication.run(OmqAuthentificationApplication.class, args);
    }

}
