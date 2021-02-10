package mk.ukim.finki.emt.onlinemagazine.reaction.domain.repository;

import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleId;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleReaction;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleReactionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleReactionRepository extends JpaRepository<ArticleReaction, ArticleReactionId> {
    List<ArticleReaction> findAllByArticleId(ArticleId articleId);
}
