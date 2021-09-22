package com.finki.emt.sharedkernel.infra;

import com.finki.emt.sharedkernel.domain.events.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
