package com.finki.emt.subscriptionmenagement.domain.model;

import com.finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

import javax.validation.constraints.NotNull;


public class SubscriptionId extends DomainObjectId {
    private SubscriptionId() {
        super(DomainObjectId.randomId(SubscriptionId.class).getId());
    }

    public SubscriptionId(@NotNull String uuid) {
        super(uuid);
    }
}
