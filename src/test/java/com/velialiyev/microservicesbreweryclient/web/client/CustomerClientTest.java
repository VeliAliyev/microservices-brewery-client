package com.velialiyev.microservicesbreweryclient.web.client;

import com.velialiyev.microservicesbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerClientTest {
    @Autowired
    CustomerClient customerClient;
    @Test
    void getCustomerById() {
        CustomerDto found = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(found);
    }

    @Test
    void createNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Veli").build();
        URI uri = customerClient.createNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}