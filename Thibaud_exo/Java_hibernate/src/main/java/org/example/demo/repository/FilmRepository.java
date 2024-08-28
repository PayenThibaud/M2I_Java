package org.example.demo.repository;

import org.example.demo.entity.Film;
import org.example.demo.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FilmRepository {
    private final SessionFactory sessionFactory;
    private Session session;

    public FilmRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public Film createOrUpdate(Film film) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(film);
            session.getTransaction().commit();
            return film;
        }catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean delete(Film film) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(film);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public Film findById(int id) {
        session = sessionFactory.openSession();
        Film film = session.get(Film.class, id);
        session.close();
        return film;
    }

    public List<Film> findAll() {
        session = sessionFactory.openSession();
        List<Film> films = session.createCriteria(Film.class).list();
        session.close();
        return films;
    }
}
