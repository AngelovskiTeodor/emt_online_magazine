package mk.ukim.finki.emt.onlinemagazine.sharedkernel.infrastructure.eventlog;

import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.DomainEvent;

import java.util.Optional;

public interface RemoteEventTranslator {

    boolean supports(StoredDomainEvent storedDomainEvent);

    Optional<DomainEvent> translate(StoredDomainEvent remoteEvent);

}
