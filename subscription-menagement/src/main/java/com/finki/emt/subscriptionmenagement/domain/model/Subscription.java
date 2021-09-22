package com.finki.emt.subscriptionmenagement.domain.model;

import com.finki.emt.sharedkernel.domain.base.AbstractEntity;
import com.finki.emt.sharedkernel.domain.calculations.Currency;
import com.finki.emt.sharedkernel.domain.calculations.Money;
import com.finki.emt.subscriptionmenagement.domain.valueObject.Ad;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

//Agregate root - we are implementing here the main functions that are needed for business logic

@Entity
@Table(name = "subscriptions")
@Getter
public class Subscription extends AbstractEntity<SubscriptionId> {

    private Instant createdDateTime;

    @Enumerated(EnumType.STRING)
    private SubscriptionState subscriptionState;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<SubscriptionItem> subscriptionItemList;

    @Column(name = "subscription_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Subscription() {
        super(SubscriptionId.randomId(SubscriptionId.class));


    }

    public Subscription(Instant now, Currency currency) {
        super(SubscriptionId.randomId(SubscriptionId.class));
        this.createdDateTime = now;
        this.currency = currency;

    }

    //we are need this for getting the price for the subscription
    public Money totalPrice() {
        return subscriptionItemList.stream().map(SubscriptionItem::getPrice)
                .reduce(new Money(currency, 0), Money::add);
    }

    //this is in agregate root because is the service logic
    public SubscriptionItem addItem(@NotNull Ad ad) {
        Objects.requireNonNull(ad, "Ad cannot be null.");
        var item = new SubscriptionItem(ad.getRating(), ad.getPrice(), ad.getId());
        subscriptionItemList.add(item);
        return item;
    }

    public void removeItem(@NotNull SubscriptionItemId subscriptionItemId) {
        Objects.requireNonNull(subscriptionItemId, "subscriptionItemId cannot be null.");
        this.subscriptionItemList.removeIf(item -> item.getId().equals(subscriptionItemId));
    }
}
