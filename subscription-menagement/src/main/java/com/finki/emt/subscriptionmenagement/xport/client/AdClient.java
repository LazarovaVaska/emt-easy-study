package com.finki.emt.subscriptionmenagement.xport.client;

import com.finki.emt.subscriptionmenagement.domain.valueObject.Ad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class AdClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public AdClient(@Value("${app.ad-catalog.url}") String serverUrl) {
        this.restTemplate = new RestTemplate();
        this.serverUrl = serverUrl;
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Ad> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/ad").build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Ad>>() {

            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
