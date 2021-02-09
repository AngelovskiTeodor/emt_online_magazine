package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.reaction;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class NumUses implements ValueObject{

    private final Integer numberOfUses;

    public NumUses(@NonNull Integer numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    public NumUses() {
        this.numberOfUses = 0;
    }

    public NumUses increment(){
        return new NumUses(this.numberOfUses+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumUses numUses = (NumUses) o;
        return Objects.equals(numberOfUses, numUses.numberOfUses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfUses);
    }

    @Override
    public String toString() {
        return "NumUses{" +
                "numberOfUses=" + numberOfUses +
                '}';
    }
}
