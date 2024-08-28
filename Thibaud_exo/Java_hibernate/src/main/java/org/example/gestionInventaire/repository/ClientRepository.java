package org.example.gestionInventaire.repository;

import org.example.gestionInventaire.entity.Client;
import org.example.gestionInventaire.entity.Vente;
import org.example.gestionInventaire.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientRepository extends BaseRepository<Client> {

//    private final SessionFactory sessionFactory;
//    private Session session;


    public ClientRepository() {
        super(Client.class);
//        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

//    public void AddVenteInClient(int idClient, List<Vente> ventes) {
//        try {
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            Client client = findById(idClient);
//            client.setVentes(ventes);
//            session.saveOrUpdate(client);
//            session.getTransaction().commit();
//            session.close();
//        }catch (Exception e) {
//            session.getTransaction().rollback();
//        }finally {
//            session.close();
//        }
//    }
}
