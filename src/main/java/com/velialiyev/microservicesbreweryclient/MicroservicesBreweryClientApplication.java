package com.velialiyev.microservicesbreweryclient;

import com.velialiyev.microservicesbreweryclient.web.client.BreweryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(BreweryClient.class)
public class MicroservicesBreweryClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesBreweryClientApplication.class, args);
    }

}
