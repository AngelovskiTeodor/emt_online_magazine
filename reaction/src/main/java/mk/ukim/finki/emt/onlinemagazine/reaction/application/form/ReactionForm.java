package mk.ukim.finki.emt.onlinemagazine.reaction.application.form;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity.Popularity;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.reaction.Description;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

@Getter
public class ReactionForm implements Serializable {

    @NotNull
    private Description description;

    @NotNull
    private Popularity basePopularity;

    public ReactionForm() {
    }

    public ReactionForm(@NotNull Description description, @NotNull Popularity basePopularity) {
        this.description = description;
        this.basePopularity = basePopularity;
    }

    public Description getDescription() {
        return description;
    }

    public Popularity getBasePopularity() {
        return basePopularity;
    }
}
