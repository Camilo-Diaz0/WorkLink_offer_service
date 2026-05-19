package com.example.offer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.offer_service.config")
public class OfferServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OfferServiceApplication.class, args);
    }
}
