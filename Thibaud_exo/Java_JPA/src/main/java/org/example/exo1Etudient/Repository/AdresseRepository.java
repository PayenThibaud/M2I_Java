package org.example.exo1Etudient.Repository;

import org.example.exo1Etudient.entity.Adresse;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AdresseRepository {

    private  EntityManager em;

    public AdresseRepository(EntityManager em) {
        this.em = em;
    }

    public void add(Adresse adresse){
        em.getTransaction().begin();
        em.persist(adresse);
        em.getTransaction().commit();
    }

    public void update (int id, Adresse adresseUpdate) {

        Adresse adresse = getById(id);

        if (adresse == null) {
            System.out.println("pas d adresse avec cet id");
            return;
        }
        em.getTransaction().begin();

        adresse.setNumero(adresseUpdate.getNumero());
        adresse.setRue(adresseUpdate.getRue());
        adresse.setVille(adresseUpdate.getVille());
        adresse.setCodePostal(adresseUpdate.getCodePostal());

        em.merge(adresse);
        em.getTransaction().commit();
    }

    public void delete (int id) {
        Adresse adresse = getById(id);
        if (adresse == null) {
            System.out.println("pas d adresse avec cet id");
            return;
        }
        em.getTransaction().begin();
        em.remove(adresse);
        em.getTransaction().commit();
    }

    public  Adresse getById (int id) {
        Adresse adresse = em.find(Adresse.class, id);
        if(adresse != null){
            return adresse;
        }else {
            System.out.println("pas d adresse avec cet id");
            return null;
        }
    }

    public  List<Adresse> getAll() {
        TypedQuery<Adresse> query = em.createQuery("select e from Adresse e", Adresse.class);
        return query.getResultList();
    }
}

