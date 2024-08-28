package org.example.gestionInventaire.repository;

import org.example.gestionInventaire.entity.Article;
import org.example.gestionInventaire.entity.Vente;
import org.example.gestionInventaire.enums.Categorie;
import org.example.gestionInventaire.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

    public void addArticleInVente(int idVente, List<Article> articles) {

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            Vente vente = session.get(Vente.class, idVente);
            if (vente == null) {
                System.out.println("Aucune vente trouvée avec cet ID");
                return;
            }

            if (vente.getArticles() == null) {
                vente.setArticles(new ArrayList<>());
            }

            for (Article article : articles) {
                Article articleRecup = session.get(Article.class, article.getId());

                if (articleRecup.getVentes() == null) {
                    articleRecup.setVentes(new ArrayList<>());
                }

                if (!articleRecup.getVentes().contains(vente)) {
                    articleRecup.getVentes().add(vente);
                    session.saveOrUpdate(articleRecup);
                }

                if (!vente.getArticles().contains(articleRecup)) {
                    vente.getArticles().add(articleRecup);
                }
            }

            session.saveOrUpdate(vente);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public boolean deleteVenteAndArticle_Vente(int idVente) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            Vente vente = session.get(Vente.class, idVente);
            if (vente == null) {
                System.out.println("Aucune vente trouvée avec cet ID");
                return false;
            }

            for (Article article : vente.getArticles()) {
                article.getVentes().remove(vente);
                session.saveOrUpdate(article);
            }

            vente.getArticles().clear();

            session.delete(vente);

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
