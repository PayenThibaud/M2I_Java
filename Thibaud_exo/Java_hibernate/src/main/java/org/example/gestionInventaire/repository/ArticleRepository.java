package org.example.gestionInventaire.repository;

import org.example.gestionInventaire.entity.Article;


public class ArticleRepository extends BaseRepository<Article> {
    public ArticleRepository() {
        super(Article.class);
    }
}
