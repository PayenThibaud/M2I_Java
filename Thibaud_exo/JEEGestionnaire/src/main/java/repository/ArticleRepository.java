package repository;

import entity.Article;

public class ArticleRepository extends BaseRepository<Article> {
    public ArticleRepository() {
        super(Article.class);
    }
}
