package com.finki.emt.subscriptionmenagement.service.forms;

import com.finki.emt.subscriptionmenagement.domain.valueObject.Ad;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class SubscriptionItemForm {

    @NotNull
    private Ad ad;

}
