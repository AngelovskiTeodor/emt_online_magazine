package mk.ukim.finki.emt.onlinemagazine.reaction.application;

import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.Article;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleId;

import java.util.List;

public interface ArticleService {
    public List<Article> findAll();

    public Article findById(ArticleId articleId);
}
