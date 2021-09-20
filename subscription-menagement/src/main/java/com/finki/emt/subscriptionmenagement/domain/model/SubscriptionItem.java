package com.finki.emt.subscriptionmenagement.domain.model;

import com.finki.emt.sharedkernel.domain.base.AbstractEntity;
import com.finki.emt.sharedkernel.domain.calculations.Rating;
import com.finki.emt.subscriptionmenagement.domain.valueObject.AdId;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "subscription_items")
@Getter
public class SubscriptionItem extends AbstractEntity<SubscriptionItemId> {

    @Column(name="item_rating", nullable = false)
    private Rating itemRating;

//    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "ad_id", nullable = false))
    private AdId adId;
//
//    private SubscriptionItem() {
//        super(DomainObjectId.r)
//    }

    public SubscriptionItem(){}
}