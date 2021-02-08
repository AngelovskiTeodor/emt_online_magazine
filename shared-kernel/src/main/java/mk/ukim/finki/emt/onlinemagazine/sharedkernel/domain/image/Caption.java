package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.image;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Caption implements ValueObject {

    private final String caption;

    private Caption(@NonNull String caption) {
        this.caption = caption;
    }

    public Caption() { this.caption = null; }

    public static Caption createCaption (@NonNull String caption) {
        return new Caption(caption);
    }

    @Override
    public String toString() {
        return "Caption{" +
                "caption='" + caption + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caption caption1 = (Caption) o;
        return caption.equals(caption1.caption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caption);
    }
}
