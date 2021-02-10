package mk.ukim.finki.emt.onlinemagazine.article.domain.repository;

import mk.ukim.finki.emt.onlinemagazine.article.domain.model.Article;
import mk.ukim.finki.emt.onlinemagazine.article.domain.model.ArticleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, ArticleId> {
}
