package mk.ukim.finki.emt.onlinemagazine.reaction.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.popularity.Popularity;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.reaction.Description;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.reaction.NumUses;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "reactions")
@Getter
public class Reaction extends AbstractEntity<ReactionId> {

    @Version
    private Long version;

    @Embedded
    private Description description;

    @Embedded
    private Popularity basePopularity;

    @Embedded
    private NumUses numberOfUses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ArticleReaction> articleReactions;

    //  Used by JPA
    protected Reaction() {
    }

    public Reaction(ReactionId id, Description description, Popularity basePopularity, NumUses numberOfUses) {
        super(id);
        this.description = description;
        this.basePopularity = basePopularity;
        this.numberOfUses = numberOfUses;
        this.articleReactions = articleReactions;
    }

    public Reaction(Description description, Popularity basePopularity, NumUses numberOfUses) {
        this.description = description;
        this.basePopularity = basePopularity;
        this.numberOfUses = numberOfUses;
    }

    public Reaction(Description description, Popularity basePopularity) {
        this.description = description;
        this.basePopularity = basePopularity;
        this.numberOfUses = new NumUses(0);
    }

    public Description getDescription() {
        return description;
    }

    public Popularity getBasePopularity() {
        return basePopularity;
    }

    public NumUses getNumberOfUses() {
        return numberOfUses;
    }

    public Set<ArticleReaction> getArticleReactions() {
        return articleReactions;
    }
}
