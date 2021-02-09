package mk.ukim.finki.emt.onlinemagazine.article.application.form;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.ArticleContent;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.Author;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.datetime.PostingDate;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity.Popularity;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Getter
public class ArticleForm implements Serializable {

    @NotNull
    private Author author;

    @NotNull
    private PostingDate publishing_date;

    @NotNull
    private ArticleContent content;

    @NotNull
    private Popularity popularity;

    public ArticleForm(@NotNull Author author, @NotNull PostingDate publishing_date, @NotNull ArticleContent content, @NotNull Popularity popularity) {
        this.author = author;
        this.publishing_date = publishing_date;
        this.content = content;
        this.popularity = popularity;
    }

    public ArticleForm(@NotNull Author author, @NotNull ArticleContent content, @NotNull Popularity popularity) {
        this.author = author;
        this.publishing_date = PostingDate.createPostingDate(Instant.now());
        this.content = content;
        this.popularity = popularity;
    }

    public ArticleForm() {
    }
}
