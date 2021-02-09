package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.reaction;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.ValueObject;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Description implements ValueObject {

    private final String description;

    public Description() {
        this.description = null;
    }

    public Description(@NonNull String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "Description{" +
                "description='" + description + '\'' +
                '}';
    }
}
