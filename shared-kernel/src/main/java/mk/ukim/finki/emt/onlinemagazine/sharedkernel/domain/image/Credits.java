package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.image;

import lombok.Getter;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Credits {
    //TODO: add value object inheritance

    private final String credits;

    private Credits(@NonNull String credits) {
        this.credits = credits;
    }

    public Credits(){
        this.credits = null;
    }

    public static Credits createCredits (@NonNull String credits) {
        return new Credits(credits);
    }

    @Override
    public String toString() {
        return "Credits{" +
                "credits='" + credits + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credits credits1 = (Credits) o;
        return credits.equals(credits1.credits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credits);
    }
}
