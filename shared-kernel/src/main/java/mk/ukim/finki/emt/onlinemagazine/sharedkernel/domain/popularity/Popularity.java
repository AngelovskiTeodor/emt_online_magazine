package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Popularity implements ValueObject {

    private final Double popularityValue;

    public Popularity() {
        this.popularityValue = null;
    }

    public Popularity(Double popularityValue) {
        this.popularityValue = popularityValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Popularity that = (Popularity) o;
        return Objects.equals(popularityValue, that.popularityValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(popularityValue);
    }

    @Override
    public String toString() {
        return "Popularity{" +
                "popularityValue=" + popularityValue +
                '}';
    }

}