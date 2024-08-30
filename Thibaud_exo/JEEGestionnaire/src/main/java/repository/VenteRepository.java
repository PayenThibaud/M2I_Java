package repository;

import entity.Article;
import entity.Article_vente;
import entity.Vente;
import enums.Categorie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.SessionFactorySingleton;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class VenteRepository extends BaseRepository<Vente> {

    private final SessionFactory sessionFactory;
    private Session session;

    public VenteRepository() {
        super(Vente.class);
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
    }


    @Override
    public boolean delete(Vente vente) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            Vente venteSupr = session.get(Vente.class, vente.getId());
            if (venteSupr == null) {
                System.out.println("Aucune vente trouvée avec cet ID");
                return false;
            }

            List<Article_vente> articleVentes = session.createQuery(
                            "FROM Article_vente av WHERE av.vente.id = :venteId",
                            Article_vente.class)
                    .setParameter("venteId", venteSupr.getId())
                    .getResultList();


            for (Article_vente av : articleVentes) {
                Article article = av.getArticle();
                article.setQuantite(article.getQuantite() + av.getQuantiteArticle());
                session.update(article);
            }

            for (Article_vente av : articleVentes) {
                session.delete(av);
            }

            session.delete(venteSupr);

            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }


    public List<Vente> getVenteByArticle(int idArticle) {

        List<Vente> ventes = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "SELECT v FROM Vente v JOIN v.articles a WHERE a.id = :idArticle";
            Query query = session.createQuery(hql, Vente.class);
            query.setParameter("idArticle", idArticle);
            ventes = query.getResultList();

            session.getTransaction().commit();
            return ventes;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return ventes;
        } finally {
            session.close();
        }
    }

    public List<Vente> getVenteByCategorie(Categorie categorie) {

        List<Vente> ventes = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "SELECT DISTINCT v FROM Vente v JOIN v.articles a WHERE a.categorie = :categorie";
            Query query = session.createQuery(hql, Vente.class);
            query.setParameter("categorie", categorie);

            ventes = query.getResultList();

            session.getTransaction().commit();
            return ventes;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return ventes;
        } finally {
            session.close();
        }
    }

    public List<Vente> getVenteByClient(int idClient) {

        List<Vente> ventes = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = "SELECT v FROM Vente v WHERE v.client.id = :idClient";
            Query query = session.createQuery(hql, Vente.class);
            query.setParameter("idClient", idClient);
            ventes = query.getResultList();

            session.getTransaction().commit();
            return ventes;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return ventes;
        } finally {
            session.close();
        }
    }
}