package mk.ukim.finki.emt.onlinemagazine.comment.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.Author;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.TextContent;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.datetime.PostingDate;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity.Popularity;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "comments")
@Where(clause = "deleted=false")
public class Comment extends AbstractEntity<CommentId> {

    @Version
    private Long version;

    private boolean deleted = false;

    @Embedded
    private ArticleId articleId;

    @Embedded
    private Author author;

    @Embedded
    private PostingDate commentDate;

    @Embedded
    private TextContent textContent;

    @Embedded
    private Popularity popularity;

    public Comment() {
    }

    public Comment(ArticleId articleId, Author author, PostingDate commentDate, TextContent textContent, Popularity popularity) {
        this.articleId = articleId;
        this.author = author;
        this.commentDate = commentDate;
        this.textContent = textContent;
        this.popularity = popularity;
    }

    public Comment(CommentId id, ArticleId articleId, Author author, PostingDate commentDate, TextContent textContent, Popularity popularity) {
        super(id);
        this.articleId = articleId;
        this.author = author;
        this.commentDate = commentDate;
        this.textContent = textContent;
        this.popularity = popularity;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public ArticleId getArticleId() {
        return articleId;
    }

    public void setArticleId(ArticleId articleId) {
        this.articleId = articleId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public PostingDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(PostingDate commentDate) {
        this.commentDate = commentDate;
    }

    public TextContent getTextContent() {
        return textContent;
    }

    public void setTextContent(TextContent textContent) {
        this.textContent = textContent;
    }

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }
}
