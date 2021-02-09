package mk.ukim.finki.emt.onlinemagazine.reaction.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.reaction.Description;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.reaction.NumUses;

import javax.persistence.*;

@Entity
@Table(name = "reactions")
@Getter
public class Reaction extends AbstractEntity<ReactionId> {

    @Version
    private Long version;

    @Embedded
    private Description description;

    @Embedded
    private NumUses numberOfUses;

    
}
