package mk.ukim.finki.emt.onlinemagazine.reaction.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.Author;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "article_reactions")
@Getter
public class ArticleReaction extends AbstractEntity<ArticleReactionId> {

    @Embedded
    @AttributeOverride(name="id",column = @Column(name="article_id",nullable = false))
    private ArticleId articleId;

    @Embedded
    private Author author;

    @Embedded
    private ReactionId reactionId;

    //  Used by JPA
    protected ArticleReaction() {
    }

    public ArticleReaction(ArticleReactionId id, ArticleId articleId, Author author, ReactionId reactionId) {
        super(id);
        this.articleId = articleId;
        this.author = author;
        this.reactionId = reactionId;
    }

    public ArticleReaction(ArticleId articleId, Author author, ReactionId reactionId) {
        this.articleId = articleId;
        this.author = author;
        this.reactionId = reactionId;
    }

    public ArticleId getArticleId() {
        return articleId;
    }

    public Author getAuthor() {
        return author;
    }

    public ReactionId getReactionId() {
        return reactionId;
    }
}
