package com.finki.emt.subscriptionmenagement.domain.model;

import com.finki.emt.sharedkernel.domain.base.AbstractEntity;
import com.finki.emt.sharedkernel.domain.calculations.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

//Agregate root - we are implementing here the main functions that are needed for business logic

@Entity
@Table(name = "subscriptions")
public class Subscription extends AbstractEntity<SubscriptionId> {

    private Instant createdDateTime;

    @Enumerated(EnumType.STRING)
    private SubscriptionState subscriptionState;

    //we are need this for getting the price for the subscription
    private Money price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<SubscriptionItem> subscriptionItemList;

    public Subscription() {
    }
}
