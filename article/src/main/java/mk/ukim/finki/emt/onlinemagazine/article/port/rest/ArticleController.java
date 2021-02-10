package mk.ukim.finki.emt.onlinemagazine.article.port.rest;

import mk.ukim.finki.emt.onlinemagazine.article.application.ArticleService;
import mk.ukim.finki.emt.onlinemagazine.article.domain.model.Article;
import mk.ukim.finki.emt.onlinemagazine.article.domain.model.ArticleId;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable("id") String articleId) {
        return this.articleService.findById(new ArticleId(articleId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Article> findAll() {
        return this.articleService.findAll();
    }
}