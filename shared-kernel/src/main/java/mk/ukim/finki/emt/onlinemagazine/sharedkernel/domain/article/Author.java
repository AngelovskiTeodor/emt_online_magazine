package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
public class Author implements ValueObject {

    private final String author;

    private Author(@NonNull String author) {
        this.author = author;
    }

    public Author() {
        this.author = null;
    }

    public static Author createAuthor(@NonNull String author) {
        return new Author (author);
    }

    @Override
    public String toString() {
        return "Author{" +
                "author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author1 = (Author) o;
        return author.equals(author1.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }
}
