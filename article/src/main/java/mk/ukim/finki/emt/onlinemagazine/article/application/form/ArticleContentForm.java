package mk.ukim.finki.emt.onlinemagazine.article.application.form;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.FeaturedImage;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.TextContent;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.Title;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
public class ArticleContentForm implements Serializable {

    @NotNull
    private Title title;

    @NotNull
    private FeaturedImage featuredImage;

    @NotNull
    private TextContent textContent;

    public ArticleContentForm(@NotNull Title title, @NotNull FeaturedImage featuredImage, @NotNull TextContent textContent) {
        this.title = title;
        this.featuredImage = featuredImage;
        this.textContent = textContent;
    }

    public ArticleContentForm() {
    }
}
