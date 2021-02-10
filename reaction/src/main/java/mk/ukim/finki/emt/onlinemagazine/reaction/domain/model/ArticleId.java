package mk.ukim.finki.emt.onlinemagazine.reaction.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class ArticleId extends DomainObjectId {

    protected ArticleId() {
        super(DomainObjectId.randomId(ArticleId.class).toString());
    }

    @JsonCreator
    public ArticleId(String id) {
        super(id);
    }
}
