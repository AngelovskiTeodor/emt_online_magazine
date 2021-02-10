package mk.ukim.finki.emt.onlinemagazine.article.application;

import mk.ukim.finki.emt.onlinemagazine.article.domain.model.Article;
import mk.ukim.finki.emt.onlinemagazine.article.domain.model.ArticleId;
import mk.ukim.finki.emt.onlinemagazine.article.domain.repository.ArticleRepository;
import mk.ukim.finki.emt.onlinemagazine.article.integration.ArticleReactionCreatedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @NonNull
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @NonNull
    public Optional<Article> findById(@NonNull ArticleId articleId) {
        Objects.requireNonNull(articleId, "articleId must not be null");
        return articleRepository.findById(articleId);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onArticleReactionCreated(ArticleReactionCreatedEvent event) {
        Article article = articleRepository.findById(event.getArticleId()).orElseThrow(RuntimeException::new);
        article.setPopularity(event.getPopularity());
        articleRepository.saveAndFlush(article);
    }


}