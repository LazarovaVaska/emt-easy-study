package com.finki.emt.subscriptionmenagement.domain.valueObject;

import com.finki.emt.sharedkernel.domain.base.DomainObjectId;


import javax.persistence.Embeddable;

@Embeddable
public class AdId extends DomainObjectId {
    private AdId(){
        super(DomainObjectId.randomId(AdId.class).getId());

    }

    public AdId(String uuid) {
        super(uuid);
    }
}
