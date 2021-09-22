package com.finki.emt.adcatalog.xport.rest;

import com.finki.emt.adcatalog.domain.models.Ad;
import com.finki.emt.adcatalog.domain.models.AdId;
import com.finki.emt.adcatalog.services.AdService;
import com.finki.emt.adcatalog.services.form.AdForm;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ad")
@AllArgsConstructor
public class AdResource {
    private final AdService adService;

    @GetMapping()
    public List<Ad> getAll() {
        return adService.getAll();
    }

    @PostMapping("/create")
    public Ad createAd(@RequestBody AdForm request) {
        return adService.createAd(request);
    }

    @GetMapping("/{id}")
    public Ad getById(@PathVariable("id") String id) {
        return adService.findById(AdId.of(id));
    }

    @PutMapping("/{adId}/subscribe")
    public Ad subscriptionItemCreated(@PathVariable("adId") String id) {
        return adService.subscriptionItemCreated(AdId.of(id));
    }

}
