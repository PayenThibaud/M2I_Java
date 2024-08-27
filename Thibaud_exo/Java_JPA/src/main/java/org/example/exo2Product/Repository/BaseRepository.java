package org.example.exo2Product.Repository;

import org.example.exo2Product.Exception.NotFoundException;
import org.example.exo2Product.Exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;


public abstract class BaseRepository<T> {

    private EntityManager em;

    public BaseRepository(EntityManager em) {
        this.em = em;
    }

    public T add(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    public boolean delete(T entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    public T getById(Class<T> classe, Long id) {
        T entity = em.find(classe, id);
        if (entity != null) {
            return entity;
        } else {
            throw new NotFoundException("Entity not found at id : " + id);
        }
    }

    public List<T> getAll(Class<T> classe) {
        String requeteString = "FROM "+classe.getSimpleName();
        return em.createQuery(requeteString, classe).getResultList();
    }

}
