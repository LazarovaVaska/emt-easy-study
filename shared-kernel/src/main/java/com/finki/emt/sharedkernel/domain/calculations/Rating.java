package com.finki.emt.sharedkernel.domain.calculations;

import com.finki.emt.sharedkernel.domain.base.ValueObject;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;

import javax.persistence.Embeddable;

//We are using this class to easily change the rating for specific ad
//it is created in shared-kernel because we need it multiple modules

@Embeddable
@Getter
public class Rating implements ValueObject {

    private final double rating;
    private final int numberOfRatings;

    protected Rating() {
        this.rating = 0.0;
        this.numberOfRatings = 0;
    }

    public Rating(@NotNull double rating) {
        this.rating = rating;
        this.numberOfRatings = getNumberOfRatings() + 1;
    }

    public static Rating valueOf(double rating) {
        return new Rating(rating);
    }

    //we are adding and then divide to the number of ratings
    public Rating change(Rating object) {
        return new Rating((rating + object.rating) / object.numberOfRatings);
    }

}
