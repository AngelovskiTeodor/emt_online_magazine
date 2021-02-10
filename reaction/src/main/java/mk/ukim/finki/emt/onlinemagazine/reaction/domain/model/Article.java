package mk.ukim.finki.emt.onlinemagazine.reaction.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.ArticleContent;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.Author;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.datetime.PostingDate;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity.Popularity;


@Getter
public class Article {
    private Author author;

    private PostingDate publishing_date;

    private ArticleContent content;

    private Popularity popularity;

    public Article() {
    }

    public Article(Author author, PostingDate publishing_date, ArticleContent content, Popularity popularity) {
        this.author = author;
        this.publishing_date = publishing_date;
        this.content = content;
        this.popularity = popularity;
    }

    public Author getAuthor() {
        return author;
    }

    public PostingDate getPublishing_date() {
        return publishing_date;
    }

    public ArticleContent getContent() {
        return content;
    }

    public Popularity getPopularity() {
        return popularity;
    }
}
