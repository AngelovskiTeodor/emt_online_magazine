package mk.ukim.finki.emt.onlinemagazine.article.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.infrastructure.eventlog.RemoteEventTranslator;
import mk.ukim.finki.emt.onlinemagazine.sharedkernel.infrastructure.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ArticleReactionCreatedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    public ArticleReactionCreatedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClass().equals("mk.ukim.finki.emt.onlinemagazine.article.integration.ArticleReactionCreatedEvent");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, ArticleReactionCreatedEvent.class));
    }
}
