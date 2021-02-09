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


}
