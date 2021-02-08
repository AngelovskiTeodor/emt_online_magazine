package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base;

import lombok.NonNull;

import java.time.Instant;

public interface DomainEvent extends DomainObject {

    @NonNull
    Instant occurredOn();
}
