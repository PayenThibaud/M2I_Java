package org.example;

import org.example.entity.Plante;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.util.List;

public class Main {

    private static  EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");
        em = emf.createEntityManager();

        Plante plante = Plante.builder().name("Plante").color("red").build();

//        add(plante);

        getByReference(3);
//
//        edit(2,"plante2","vert");

        delete(1);

    }


    public static void add (Plante plante) {
//        EntityTransaction transaction =  em.getTransaction();
//        transaction.begin();
        em.getTransaction().begin();
        em.persist(plante);
        em.getTransaction().commit();
    }

    public static void getAll (){
        TypedQuery<Plante> query = em.createQuery("select p from Plante p ",Plante.class);
        List<Plante> plantes = query.getResultList();

//        plantes.forEach(System.out::println);

        for (Plante plante : plantes){
            System.out.println(plante);
        }
    }

    public static void getById (int id){
        Plante plante = em.find(Plante.class,id);
        if(plante != null){
            System.out.println(plante);
        }else{
            System.out.println("aucune plante trouvé");
        }
    }

    public static Plante getByReference (int id){
        try{
            return em.getReference(Plante.class,id);
        }catch (EntityNotFoundException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void edit (int id , String name, String color){
        Plante plante = getByReference(id);
        em.getTransaction().begin();
        plante.setName(name);
        plante.setColor(color);

        em.getTransaction().commit();
    }

    public static void delete (int id){
        Plante plante = getByReference(id);
        if(plante == null){
            System.out.println("no plant found");
            return ;
        }
        em.getTransaction().begin();
        em.remove(plante);
        em.getTransaction().commit();
    }

}