package mk.ukim.finki.emt.onlinemagazine.article.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.ArticleContent;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.Author;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Getter
@Table(name="articles")
@Where(clause = "deleted=false")
public class Article {

    @Id
    private String ArticleId;

    @Version
    private Long version;

    private boolean deleted = false;

    //TODO: Add required props

    private Author author;

    private PostingDate publishing_date;

    private ArticleContent content;

}
