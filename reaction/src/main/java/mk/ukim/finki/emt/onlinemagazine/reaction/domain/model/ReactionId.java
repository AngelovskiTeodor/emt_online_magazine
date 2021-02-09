package mk.ukim.finki.emt.onlinemagazine.reaction.domain.model;

import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;

@Embeddable
public class ReactionId extends DomainObjectId {

    public ReactionId(@NonNull String id) {
        super(id);
    }

    public ReactionId(){
        super(DomainObjectId.randomId(ReactionId.class).toString());
    }
}
