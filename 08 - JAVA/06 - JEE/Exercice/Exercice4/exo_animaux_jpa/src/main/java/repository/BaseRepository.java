package repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.SessionFactorySingleton;

import java.util.List;

public class BaseRepository<T> {
    private final SessionFactory sessionFactory;
    private final Class<T> entityClass;

    public BaseRepository(Class<T> entityClass) {
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
        this.entityClass = entityClass;
    }



    public T createOrUpdate(T entity) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
            return entity;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    public boolean delete(T entity) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public T findById(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            T entity = session.get(entityClass, id);
            session.getTransaction().commit();
            return entity;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<T> entities = session.createQuery(("SELECT e FROM " + entityClass.getName() + " e"), entityClass).list();
            session.getTransaction().commit();
            return entities;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            return null;
        } finally {
            session.close();
        }
    }
}
