package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.image;

import lombok.Getter;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import java.util.Base64;
import java.util.Objects;

@Getter
@Embeddable
public class Image {
    //TODO: add value object inheritance

    private final Caption caption;

    private final Credits credits;

    private final Base64 imageBase64;

    private Image(Caption caption, Credits credits, @NonNull Base64 imageBase64) {
        this.caption = caption;
        this.credits = credits;
        this.imageBase64 = imageBase64;
    }

    public Image(){
        this.caption = null;
        this.credits = null;
        this.imageBase64 = null;
    }

    public static Image createImage (Caption caption, Credits credits, @NonNull Base64 imageBase64) {
        return new Image(caption, credits, imageBase64);
    }

    @Override
    public String toString() {
        return "Image{" +
                "caption=" + caption +
                ", credits=" + credits +
                ", imageBase64=" + imageBase64 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image img = (Image) o;
        return imageBase64.equals(img.imageBase64) && credits.equals(img.credits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageBase64);
    }
}
