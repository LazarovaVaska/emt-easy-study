package com.finki.emt.adcatalog.domain.models;


import com.finki.emt.sharedkernel.domain.calculations.Rating;
import com.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ads")
public class Ad extends AbstractEntity<AdId> {

    private String name;

    private Rating rating;


}
