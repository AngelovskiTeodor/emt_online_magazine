package mk.ukim.finki.emt.onlinemagazine.article.application.form;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Base64;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.image.Caption;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.image.Credits;

@Getter
public class ImageForm implements Serializable{

    @NotNull
    private Caption caption;

    @NotNull
    private Credits credits;

    @NotNull
    private Base64 imageBase64;

    public ImageForm(@NotNull Caption caption, @NotNull Credits credits, @NotNull Base64 imageBase64) {
        this.caption = caption;
        this.credits = credits;
        this.imageBase64 = imageBase64;
    }

    public ImageForm() {
    }
}
