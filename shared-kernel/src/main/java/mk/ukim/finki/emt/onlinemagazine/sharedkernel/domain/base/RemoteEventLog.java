package mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base;

import mk.ukim.finki.emt.onlinemagazine.sharedkernel.infrastructure.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {
    List<StoredDomainEvent> events();
}
