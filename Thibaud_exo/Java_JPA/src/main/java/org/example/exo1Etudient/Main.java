package org.example.exo1Etudient;

import org.example.exo1Etudient.entity.Etudient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {

    private static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
        em = emf.createEntityManager();

        Etudient etudient = Etudient.builder()
                .nom("Titi2")
                .prenom("Toto2")
                .classe("6Ee")
                .build();




//        add(etudient);

        System.out.println(getAll());
        System.out.println(getById(1));


        Etudient etudient2 = Etudient.builder()
                .nom("Toto")
                .prenom("Titi")
                .build();
        update(1, etudient2);

        System.out.println(getById(1));

        delete(1);

        System.out.println(getAll());
    }

    public static void add (Etudient etudient){
        em.getTransaction().begin();
        em.persist(etudient);
        em.getTransaction().commit();
    }

    public static void update (int id, Etudient etudientUpdate) {

        Etudient etudient = getById(id);

        if (etudient == null) {
            System.out.println("pas d etudient avec cet id");
            return;
        }
        em.getTransaction().begin();

        etudient.setNom(etudientUpdate.getNom());
        etudient.setPrenom(etudientUpdate.getPrenom());

        if (etudientUpdate.getClasse() != null) {
            etudient.setClasse(etudientUpdate.getClasse());
        }

        em.merge(etudient);
        em.getTransaction().commit();
    }

    public static void delete (int id) {
        Etudient etudient = getById(id);
        if (etudient == null) {
            System.out.println("pas d etudient avec cet id");
            return;
        }
        em.getTransaction().begin();
        em.remove(etudient);
        em.getTransaction().commit();
    }

    public static Etudient getById (int id) {
        Etudient etudient = em.find(Etudient.class, id);
        if(etudient != null){
            return etudient;
        }else {
            System.out.println("pas d etudient avec cet id");
            return etudient;
        }
    }

    public static List<Etudient> getAll() {
        TypedQuery<Etudient> query = em.createQuery("select e from Etudient e", Etudient.class);
        return query.getResultList();
    }


}