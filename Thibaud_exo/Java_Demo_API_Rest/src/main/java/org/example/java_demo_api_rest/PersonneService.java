package org.example.java_demo_api_rest;

import jakarta.enterprise.context.ApplicationScoped;

//
@ApplicationScoped
public class PersonneService {
    public Person save(String nom, String prenom, int age) {
        return new Person(nom, prenom, age);
    }
}
