package org.example.java_hopital.repository;

import org.example.java_hopital.entity.Consultation;
import org.example.java_hopital.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ConsultationRepository extends BaseRepository<Consultation> {

    private final SessionFactory sessionFactory;
    private Session session;

    public ConsultationRepository() {
        super(Consultation.class);
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    public List<Consultation> getConsultationByPatient(int idPatient) {

        List<Consultation> consultations = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "SELECT v FROM Consultation v JOIN v.patient a WHERE a.id = :idPatient";
            Query query = session.createQuery(hql, Consultation.class);
            query.setParameter("idPatient", idPatient);
            consultations = query.getResultList();

            session.getTransaction().commit();
            return consultations;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return consultations;
        } finally {
            session.close();
        }
    }
}
