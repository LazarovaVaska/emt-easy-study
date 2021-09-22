package com.finki.emt.adcatalog.domain.models;


import com.finki.emt.sharedkernel.domain.calculations.Money;
import com.finki.emt.sharedkernel.domain.calculations.Rating;
import com.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad extends AbstractEntity<AdId> {

    private String name;

    private Rating rating;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    private Money price;


    public static Ad build(String name, Money price) {
        Ad p = new Ad();
        p.price = price;
        p.name = name;
        p.rating = Rating.valueOf(0.0);
        return p;
    }


}
