package org.example;

import org.example.entity.Plante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class Main {

    private static  EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
        em = emf.createEntityManager();

//        Plante plante = Plante.builder().name("Plante").color("red").build();

        add(plante);
    }


    public static void add (Plante plante) {
//        EntityTransaction transaction =  em.getTransaction();
//        transaction.begin();
        em.getTransaction().begin();
        em.persist(plante);
        em.getTransaction().commit();
    }

}