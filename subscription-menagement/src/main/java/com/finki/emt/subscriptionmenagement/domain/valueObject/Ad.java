package com.finki.emt.subscriptionmenagement.domain.valueObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.finki.emt.sharedkernel.domain.base.ValueObject;
import com.finki.emt.sharedkernel.domain.calculations.Currency;
import com.finki.emt.sharedkernel.domain.calculations.Money;
import com.finki.emt.sharedkernel.domain.calculations.Rating;
import lombok.Getter;

@Getter
public class Ad implements ValueObject {
    private final AdId id;
    private final String name;
    private final Money price;
    private final Rating rating;

    private Ad() {
        this.id = AdId.randomId(AdId.class);
        this.name = "";
        this.price = Money.valueOf(Currency.EUR, 0);
        this.rating = Rating.valueOf(0.0);
    }

    @JsonCreator
    public Ad(AdId id, String name, Money price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}
