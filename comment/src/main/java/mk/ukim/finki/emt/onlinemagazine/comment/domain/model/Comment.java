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
    private Author author;

    @Embedded
    private PostingDate commentDate;

    @Embedded
    private TextContent textContent;

    @Embedded
    private Popularity popularity;

}
