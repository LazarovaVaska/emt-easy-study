package com.finki.emt.adcatalog.xport.rest;

import com.finki.emt.adcatalog.domain.models.Ad;
import com.finki.emt.adcatalog.services.AdService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
