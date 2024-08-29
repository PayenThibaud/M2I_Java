package org.example.gestionInventaire.repository;

import org.example.gestionInventaire.entity.Article;
import org.example.gestionInventaire.entity.Article_vente;
import org.example.gestionInventaire.entity.Vente;
import org.example.gestionInventaire.util.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Article_venteRepository extends BaseRepository<Article_vente> {

    private final SessionFactory sessionFactory;
    private Session session;

    public Article_venteRepository() {
        super(Article_vente.class);
        this.sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    @Override
    public Article_vente createOrUpdate(Article_vente article_vente){
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Article article = session.get(Article.class, article_vente.getArticle().getId());
            Vente vente = session.get(Vente.class, article_vente.getVente().getId());

            if (article == null || vente == null) {
                System.out.println("L'article ou la vente n'existe pas.");
                session.getTransaction().rollback();
                return null;
            }

            Article_vente ancientArticleVente = session.createQuery(
                            "FROM Article_vente av WHERE av.article.id = :articleId AND av.vente.id = :venteId",
                            Article_vente.class)
                    .setParameter("articleId", article_vente.getArticle().getId())
                    .setParameter("venteId", article_vente.getVente().getId())
                    .uniqueResult();

            int quantityDifference;

            if (ancientArticleVente != null) {
                quantityDifference = article_vente.getQuantiteArticle() - ancientArticleVente.getQuantiteArticle();
                ancientArticleVente.setQuantiteArticle(article_vente.getQuantiteArticle());
                session.update(ancientArticleVente);
            } else {
                quantityDifference = article_vente.getQuantiteArticle();
                session.save(article_vente);
            }

            if (article.getQuantite() < quantityDifference) {
                System.out.println("Quantité insuffisante pour l'article : " + article.getDescription());
                session.getTransaction().rollback();
                return null;
            }

            article.setQuantite(article.getQuantite() - quantityDifference);
            session.update(article);

            session.getTransaction().commit();
            return article_vente;
        }catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }

    }
}
