package com.finki.emt.adcatalog.services;

import com.finki.emt.adcatalog.domain.models.Ad;
import com.finki.emt.adcatalog.domain.models.AdId;
import com.finki.emt.adcatalog.services.form.AdForm;

import java.util.List;

public interface AdService {
    Ad findById(AdId adId);

    Ad createAd(AdForm adForm);

    Ad subscriptionItemCreated(AdId adId);

    Ad subscriptionItemRemoved(AdId adId);

    List<Ad> getAll();

    List<String> getAllCurrencies();
}
