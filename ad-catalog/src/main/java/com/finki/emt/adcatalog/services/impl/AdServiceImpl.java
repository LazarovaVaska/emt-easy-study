package com.finki.emt.adcatalog.services.impl;

import com.finki.emt.adcatalog.domain.exception.AdNotFoundException;
import com.finki.emt.adcatalog.domain.models.Ad;
import com.finki.emt.adcatalog.domain.models.AdId;
import com.finki.emt.adcatalog.domain.repository.AdRepository;
import com.finki.emt.adcatalog.services.AdService;
import com.finki.emt.adcatalog.services.form.AdForm;
import com.finki.emt.sharedkernel.domain.calculations.Currency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AdServiceImpl implements AdService {
    private final AdRepository adRepository;

    @Override
    public Ad findById(AdId adId) {
        return adRepository.findById(adId).orElseThrow(AdNotFoundException::new);
    }

    @Override
    public Ad createAd(AdForm adForm) {
        Ad ad = Ad.build(adForm.getAdName(), adForm.getPrice());
        adRepository.save(ad);
        return ad;
    }

    @Override
    public Ad subscriptionItemCreated(AdId adId) {
        Ad ad = adRepository.findById(adId).orElseThrow(AdNotFoundException::new);
//        adRepository.saveAllAndFlush(ad);
        return ad;
    }

    @Override
    public Ad subscriptionItemRemoved(AdId adId) {
        return null;
    }

    @Override
    public List<Ad> getAll() {
        return adRepository.findAll();
    }

    @Override
    public List<String> getAllCurrencies() {
        return Arrays.stream(Currency.values()).map(Enum::name).collect(Collectors.toList());
    }
}
