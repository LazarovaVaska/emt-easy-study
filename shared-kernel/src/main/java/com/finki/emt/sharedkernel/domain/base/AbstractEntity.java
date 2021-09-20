package com.finki.emt.sharedkernel.domain.base;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<ID extends DomainObjectId> {

    @EmbeddedId
    private ID id;
}
