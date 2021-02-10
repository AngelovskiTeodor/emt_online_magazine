package mk.ukim.finki.emt.onlinemagazine.reaction.domain.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleId;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ReactionId;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity.Popularity;

import java.time.Instant;

@Getter
public class ArticleReactionCreated implements DomainEvent {

    @JsonProperty("articleId")
    private final ArticleId articleId;

    @JsonProperty("Popularity")
    private final Popularity popularity;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    public ArticleReactionCreated(ArticleId articleId, Popularity popularity, Instant occurredOn) {
        this.articleId = articleId;
        this.popularity = popularity;
        this.occurredOn = occurredOn;
    }

    @Override
    public @NonNull Instant occurredOn() {
        return this.occurredOn;
    }

    public ArticleId getArticleId(){
        return this.articleId;
    }

    public Popularity getPopularity(){
        return this.popularity;
    }
}
