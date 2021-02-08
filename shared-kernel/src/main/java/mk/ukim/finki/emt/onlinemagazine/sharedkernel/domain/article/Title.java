package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Title implements ValueObject {

    private final String title;

    private Title(@NonNull String title) {
        this.title = title;
    }

    public Title() {
        this.title = null;
    }

    public static Title createTitle (@NonNull String title) {
        return new Title(title);
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return title.equals(title1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
