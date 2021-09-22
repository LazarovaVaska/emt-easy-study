package com.finki.emt.adcatalog.services.form;

import com.finki.emt.sharedkernel.domain.calculations.Money;
import lombok.Getter;

@Getter
public class AdForm {
    private String adName;
    private Money price;
}
