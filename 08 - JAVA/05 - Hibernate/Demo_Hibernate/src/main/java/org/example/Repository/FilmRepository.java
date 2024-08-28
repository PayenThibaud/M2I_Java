package org.example.Repository;

import org.example.entity.Film;
import org.example.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FilmRepository {

    private final SessionFactory sessionFactory;
    private Session session;


    public FilmRepository (){
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public Film createOrUpdate (Film film ){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(film);
            session.getTransaction().commit();
            return film;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean delete (Film film){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(film);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }

    public Film findById (int id){
        session = sessionFactory.openSession();
        Film film = session.get(Film.class,id);
        session.close();
        return film;
    }

    public List<Film> getAll (){
        session = sessionFactory.openSession();
        List<Film> films = session.createQuery("from Film",Film.class).list();
        session.close();
        return films;
    }

}
