package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class ArticleContent {
    //TODO: add value object inheritance

    private final Title title;

    private final FeaturedImage featuredImage;

    private final TextContent textContent;

    public ArticleContent() {
        this.title = null;
        this.featuredImage = null;
        this.textContent = null;
    }

    private ArticleContent(@NonNull Title title, @NonNull FeaturedImage featuredImage, @NonNull TextContent textContent) {
        this.title = title;
        this.featuredImage = featuredImage;
        this.textContent = textContent;
    }

    public static ArticleContent createArticleContent(@NonNull Title title, @NonNull FeaturedImage featuredImage, @NonNull TextContent textContent){
        return new ArticleContent(title, featuredImage, textContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.featuredImage, this.textContent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        ArticleContent ac = (ArticleContent) obj;
        if (ac.title.equals(this.title) && this.featuredImage.equals(ac.featuredImage) && this.textContent.equals(ac.textContent)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ArticleContent{" +
                "title=" + title +
                ", featuredImage=" + featuredImage +
                ", textContent=" + textContent +
                '}';
    }
}
