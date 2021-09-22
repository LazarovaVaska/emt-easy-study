package com.finki.emt.adcatalog.domain.models;

import com.finki.emt.sharedkernel.domain.base.DomainObjectId;
import com.sun.istack.NotNull;

public class AdId extends DomainObjectId {
    protected AdId() {
        super(AdId.randomId(AdId.class).getId());
    }

    public AdId(@NotNull String uuid){
        super(uuid);
    }

    public static AdId of(String uuid){
        AdId adId = new AdId(uuid);
        return adId;
    }
}
