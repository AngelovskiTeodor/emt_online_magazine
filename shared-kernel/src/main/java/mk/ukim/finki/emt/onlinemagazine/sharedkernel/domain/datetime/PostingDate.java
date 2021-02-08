package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.datetime;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;
import java.time.Instant;
import java.util.Objects;

@Embeddable
@Getter
public class PostingDate implements ValueObject {

    private final Instant postingDate;

    private PostingDate(@NonNull Instant postingDate) {
        this.postingDate = postingDate;
    }

    public PostingDate() {
        this.postingDate = null;
    }

    public static PostingDate createPostingDate (@NonNull Instant postingDate) {
        return new PostingDate(postingDate);
    }

    @Override
    public String toString() {
        return "PostingDate{" +
                "postingDate=" + postingDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostingDate date = (PostingDate) o;
        return postingDate.equals(date.postingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postingDate);
    }
}
