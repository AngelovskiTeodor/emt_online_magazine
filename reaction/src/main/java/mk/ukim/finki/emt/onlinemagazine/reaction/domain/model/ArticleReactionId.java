package mk.ukim.finki.emt.onlinemagazine.reaction.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ArticleReactionId extends DomainObjectId {
    private String id;

    protected ArticleReactionId() {
        super(DomainObjectId.randomId(ArticleReactionId.class).toString());
    }

    public ArticleReactionId(String uuid) {
        super(uuid);
        this.id=uuid;
    }

}
