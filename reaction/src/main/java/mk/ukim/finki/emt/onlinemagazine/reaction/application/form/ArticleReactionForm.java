package mk.ukim.finki.emt.onlinemagazine.reaction.application.form;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ArticleId;
import mk.ukim.finki.emt.onlinemagazine.reaction.domain.model.ReactionId;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.article.Author;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
public class ArticleReactionForm implements Serializable {

    @NotNull
    private ArticleId articleId;

    @NotNull
    private Author author;

    @NotNull
    private ReactionId reactionId;

    public ArticleReactionForm(@NotNull ArticleId articleId, @NotNull Author author, @NotNull ReactionId reactionId) {
        this.articleId = articleId;
        this.author = author;
        this.reactionId = reactionId;
    }

    public ArticleReactionForm() {
    }
}
