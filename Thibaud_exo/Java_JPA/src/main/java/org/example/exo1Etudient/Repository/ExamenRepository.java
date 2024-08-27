package org.example.exo1Etudient.Repository;

import org.example.exo1Etudient.entity.Adresse;
import org.example.exo1Etudient.entity.Etudient;
import org.example.exo1Etudient.entity.Examen;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ExamenRepository {

    private EntityManager em;

    public ExamenRepository(EntityManager em) {
        this.em = em;
    }

    public void add (Examen examen){
        em.getTransaction().begin();
        em.persist(examen);
        em.getTransaction().commit();
    }

    public void update (int id, Examen examenUpdate) {

        Examen examen = getById(id);

        if (examen == null) {
            System.out.println("pas d examen avec cet id");
            return;
        }
        em.getTransaction().begin();

        examen.setDate(examenUpdate.getDate());
        examen.setNote(examenUpdate.getNote());
        examen.setMatiere(examenUpdate.getMatiere());

        em.merge(examen);
        em.getTransaction().commit();
    }

    public void delete (int id) {
        Examen examen = getById(id);
        if (examen == null) {
            System.out.println("pas d examen avec cet id");
            return;
        }
        em.getTransaction().begin();
        em.remove(examen);
        em.getTransaction().commit();
    }

    public Examen getById (int id) {
        Examen examen = em.find(Examen.class, id);
        if(examen != null){
            return examen;
        }else {
            System.out.println("pas d examen avec cet id");
            return examen;
        }
    }

    public List<Examen> getAll() {
        TypedQuery<Examen> query = em.createQuery("select e from Examen e", Examen.class);
        return query.getResultList();
    }
}

