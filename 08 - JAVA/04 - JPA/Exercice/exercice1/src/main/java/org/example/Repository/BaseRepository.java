package org.example.Repository;

import org.example.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseRepository<T> {
    private EntityManager em;

    public BaseRepository(EntityManager em) {
        this.em = em;
    }

    public T save(T element){
        em.getTransaction().begin();
        em.persist(element);
        em.getTransaction().commit();
        return element;
    }

    public boolean delete (T element){
        try{
            em.getTransaction().begin();
            em.remove(element);
            em.getTransaction().commit();
            return true;
        }catch (Exception ex){
            ex.getMessage();
            return false;
        }

    }

    public T findById(Class<T> classe, int id){
        T element = em.find(classe,id);
        if(element != null){
            return element;
        }else {
            throw new NotFoundException("element not found at id :"+id);
        }

    }

    public List<T> findALl (Class<T> classe) {
        String querystr = "FROM" + classe.getSimpleName();
        return em.createQuery(querystr, classe).getResultList();
    }
}
