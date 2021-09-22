package com.finki.emt.adcatalog.xport.events;

import com.finki.emt.adcatalog.domain.models.AdId;
import com.finki.emt.adcatalog.services.AdService;
import com.finki.emt.sharedkernel.domain.config.TopicHolder;
import com.finki.emt.sharedkernel.domain.events.DomainEvent;
import com.finki.emt.sharedkernel.domain.events.subscription.SubscriptionItemCreated;
import com.finki.emt.sharedkernel.domain.events.subscription.SubscriptionItemRemoved;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdEventListener {

    private final AdService adService;

    @KafkaListener(topics= TopicHolder.TOPIC_SUBSCRIPTION_ITEM_CREATED, groupId = "adCatalog")
    public void consumSubscriptionCreatedEvent(String jsonMessage){
        try{
            SubscriptionItemCreated event = DomainEvent.fromJson(jsonMessage, SubscriptionItemCreated.class);
            adService.subscriptionItemCreated(AdId.of(event.getAdId()));
        }catch (Exception e ){

        }
    }

    @KafkaListener(topics= TopicHolder.TOPIC_SUBSCRIPTION_ITEM_REMOVED, groupId = "adCatalog")
    public void consumSubscriptionRemovedEvent(String jsonMessage){
        try{
            SubscriptionItemRemoved event = DomainEvent.fromJson(jsonMessage, SubscriptionItemRemoved.class);
            adService.subscriptionItemRemoved(AdId.of(event.getAdId()));
        }catch (Exception e ){

        }
    }
}
