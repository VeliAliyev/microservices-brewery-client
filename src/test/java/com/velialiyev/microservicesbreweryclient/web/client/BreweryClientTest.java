package com.velialiyev.microservicesbreweryclient.web.client;

import com.velialiyev.microservicesbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);

    }

    @Test
    void createNewBeer() {
        BeerDto dto = BeerDto.builder().build();
        URI location = client.createNewBeer(dto);

        assertNotNull(location);

    }
}