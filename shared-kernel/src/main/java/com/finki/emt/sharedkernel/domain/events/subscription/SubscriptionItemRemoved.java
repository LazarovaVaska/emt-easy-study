package com.finki.emt.sharedkernel.domain.events.subscription;

import com.finki.emt.sharedkernel.domain.config.TopicHolder;
import com.finki.emt.sharedkernel.domain.events.DomainEvent;
import lombok.Getter;

@Getter
public class SubscriptionItemRemoved extends DomainEvent {

    private String adId;

    public SubscriptionItemRemoved(String topic) {
        super(TopicHolder.TOPIC_SUBSCRIPTION_ITEM_REMOVED);
    }

    public SubscriptionItemRemoved(String topic, String adId) {
        super(TopicHolder.TOPIC_SUBSCRIPTION_ITEM_REMOVED);
        this.adId = adId;
    }

}
