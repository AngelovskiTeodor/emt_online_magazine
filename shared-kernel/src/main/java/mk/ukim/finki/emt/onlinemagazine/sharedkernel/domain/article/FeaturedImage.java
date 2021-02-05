package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.image.Image;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
@Getter
public class FeaturedImage {
    // TODO: add value object inheritance

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "imageBase64", column = @Column(name = "image"))
    )
    private final Image image;

    private FeaturedImage(@NonNull Image image) {
        this.image = image;
    }

    public FeaturedImage() {
        this.image = null;
    }

    public static FeaturedImage createFeaturedImage(@NonNull Image image) {
        return new FeaturedImage(image);
    }

    @Override
    public String toString() {
        return "FeaturedImage{" +
                "image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeaturedImage fi = (FeaturedImage) o;
        return image.equals(fi.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image);
    }
}
