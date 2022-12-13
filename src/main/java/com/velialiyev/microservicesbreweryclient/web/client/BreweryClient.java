package com.velialiyev.microservicesbreweryclient.web.client;

import com.velialiyev.microservicesbreweryclient.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "client", ignoreInvalidFields = false)
public class BreweryClient {

    private final String BEER_PATH_V1 = "/api/v1/beer";
    private final RestTemplate restTemplate;

    private String apihost;

    @Autowired
    public BreweryClient( RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + "/" + uuid.toString(), BeerDto.class);
    }

    public URI createNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost+BEER_PATH_V1, beerDto);
    }

    public void deleteBeerById(UUID uuid){
        restTemplate.delete(apihost + BEER_PATH_V1 + "/" + uuid.toString());
    }
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
