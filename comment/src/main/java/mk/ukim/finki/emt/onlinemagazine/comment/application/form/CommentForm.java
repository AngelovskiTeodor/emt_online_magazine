package mk.ukim.finki.emt.onlinemagazine.comment.application.form;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.Author;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.TextContent;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.datetime.PostingDate;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity.Popularity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Getter
public class CommentForm implements Serializable {

    @NotNull
    private Author author;

    @NotNull
    private PostingDate commentDate;

    @NotNull
    private TextContent textContent;

    @NotNull
    private Popularity popularity;

    public CommentForm(@NotNull Author author, @NotNull TextContent textContent, @NotNull Popularity popularity) {
        this.author = author;
        this.commentDate = PostingDate.createPostingDate(Instant.now());
        this.textContent = textContent;
        this.popularity = popularity;
    }

    public CommentForm(@NotNull Author author, @NotNull PostingDate commentDate, @NotNull TextContent textContent, @NotNull Popularity popularity) {
        this.author = author;
        this.commentDate = commentDate;
        this.textContent = textContent;
        this.popularity = popularity;
    }

    public CommentForm() {
    }
}
