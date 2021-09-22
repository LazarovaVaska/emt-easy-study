package com.finki.emt.subscriptionmenagement.service.forms;

import com.finki.emt.sharedkernel.domain.calculations.Currency;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class SubscriptionForm {
    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<SubscriptionItemForm> items = new ArrayList<>();
}
