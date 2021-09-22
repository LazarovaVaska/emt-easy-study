package com.finki.emt.sharedkernel.domain.events.subscription;

import com.finki.emt.sharedkernel.domain.config.TopicHolder;
import com.finki.emt.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class SubscriptionItemCreated extends DomainEvent {

    private final String adId;

    public SubscriptionItemCreated(String adId) {
        super(TopicHolder.TOPIC_SUBSCRIPTION_ITEM_CREATED);
        this.adId = adId;
    }

}
