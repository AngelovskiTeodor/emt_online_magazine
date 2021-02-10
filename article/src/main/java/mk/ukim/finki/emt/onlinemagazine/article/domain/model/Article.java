package mk.ukim.finki.emt.onlinemagazine.article.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.ArticleContent;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.Author;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.datetime.PostingDate;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity.Popularity;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Getter
@Table(name="articles")
@Where(clause = "deleted=false")
public class Article extends AbstractEntity<ArticleId> {

    @Version
    private Long version;

    private boolean deleted = false;

    @Embedded
    private Author author;

    @Embedded
    private PostingDate publishing_date;

    @Embedded
    private ArticleContent content;

    @Embedded
    private Popularity popularity;

    protected Article() {
    }

    public Article(ArticleId id, Author author, PostingDate publishing_date, ArticleContent content, Popularity popularity) {
        super(id);
        this.author = author;
        this.publishing_date = publishing_date;
        this.content = content;
        this.popularity = popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }
}