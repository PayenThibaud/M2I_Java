package org.example.exo1Etudient.Repository;

import org.example.exo1Etudient.entity.Cour;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourRepository {
    private EntityManager em;

    public CourRepository(EntityManager em) {
        this.em = em;
    }

    public void add (Cour cour){
        em.getTransaction().begin();
        em.persist(cour);
        em.getTransaction().commit();
    }

    public void update (int id, Cour courUpdate) {

        Cour cour = getById(id);

        if (cour == null) {
            System.out.println("pas d cour avec cet id");
            return;
        }
        em.getTransaction().begin();

        cour.setProfesseur(courUpdate.getProfesseur());
        cour.setMatiere(courUpdate.getMatiere());
        cour.setSalle(courUpdate.getSalle());
        cour.setHorraire(courUpdate.getHorraire());

        em.merge(cour);
        em.getTransaction().commit();
    }

    public void delete (int id) {
        Cour cour = getById(id);
        if (cour == null) {
            System.out.println("pas d cour avec cet id");
            return;
        }
        em.getTransaction().begin();
        em.remove(cour);
        em.getTransaction().commit();
    }

    public Cour getById (int id) {
        Cour cour = em.find(Cour.class, id);
        if(cour != null){
            return cour;
        }else {
            System.out.println("pas d cour avec cet id");
            return cour;
        }
    }

    public List<Cour> getAll() {
        TypedQuery<Cour> query = em.createQuery("select e from Cour e", Cour.class);
        return query.getResultList();
    }
}
