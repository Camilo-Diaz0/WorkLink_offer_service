package com.example.offer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.offer_service.config")
public class OfferServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfferServiceApplication.class, args);
    }

}
