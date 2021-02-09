package mk.ukim.finki.emt.onlinemagazine.article.domain.model;

import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ArticleId extends DomainObjectId {

    public ArticleId(String id) {
        super(id);
    }

    protected ArticleId() {
        super(DomainObjectId.randomId(ArticleId.class).toString());
    }
}
