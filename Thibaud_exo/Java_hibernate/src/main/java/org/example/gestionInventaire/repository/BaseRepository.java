package org.example.gestionInventaire.repository;

import org.example.gestionInventaire.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class BaseRepository<T> {
    private final SessionFactory sessionFactory;
    private final Class<T> entityClass;
    private Session session;

    public BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public T createOrUpdate(T entity) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            return entity;
        }catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean delete(T entity) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public T findById(int id) {
        session = sessionFactory.openSession();
        T entity = session.get(entityClass, id);
        session.close();
        return entity;
    }

    public List<T> findAll() {
        session = sessionFactory.openSession();
        List<T> entities = session.createQuery("from " + entityClass.getSimpleName(), entityClass).list();
        session.close();
        return entities;
    }
}
