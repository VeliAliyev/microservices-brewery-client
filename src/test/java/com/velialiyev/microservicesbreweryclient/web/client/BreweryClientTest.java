package com.velialiyev.microservicesbreweryclient.web.client;

import com.velialiyev.microservicesbreweryclient.web.model.BeerDto;
import com.velialiyev.microservicesbreweryclient.web.model.CustomerDto;
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
    void deleteBeerById() {
        client.deleteBeerById(UUID.randomUUID());
    }

    @Test
    void createNewBeer() {
        BeerDto dto = BeerDto.builder().build();
        URI location = client.createNewBeer(dto);

        assertNotNull(location);

    }

    @Test
    void getCustomerById() {
        CustomerDto found = client.getCustomerById(UUID.randomUUID());
        assertNotNull(found);
    }

    @Test
    void createNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Veli").build();
        URI uri = client.createNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}