package com.finki.emt.subscriptionmenagement.domain.model;

import com.finki.emt.sharedkernel.domain.base.AbstractEntity;
import com.finki.emt.sharedkernel.domain.base.DomainObjectId;
import com.finki.emt.sharedkernel.domain.calculations.Money;
import com.finki.emt.sharedkernel.domain.calculations.Rating;
import com.finki.emt.subscriptionmenagement.domain.valueObject.AdId;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "subscription_items")
@Getter
public class SubscriptionItem extends AbstractEntity<SubscriptionItemId> {

    @Column(name = "item_rating", nullable = false)
    private Rating itemRating;

    private Money price;

    @AttributeOverride(name = "id", column = @Column(name = "ad_id", nullable = false))
    private AdId adId;

    public SubscriptionItem() {
    }

    public SubscriptionItem(@NotNull Rating itemRating, @NotNull Money price, @NotNull AdId adId) {
        super(DomainObjectId.randomId(SubscriptionItemId.class));
        this.itemRating = itemRating;
        this.price = price;
        this.adId = adId;
    }

    public Money subtotal() {
        return price;
    }
}