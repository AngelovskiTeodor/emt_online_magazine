package mk.ukim.finki.emt.onlinemagazine.comment.domain.model;

import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;

@Embeddable
public class CommentId extends DomainObjectId {

    public CommentId(@NonNull String id) {
        super(id);
    }

    public CommentId(){
        super(DomainObjectId.randomId(CommentId.class).toString());
    }

}
