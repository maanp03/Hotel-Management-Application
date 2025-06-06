package com.example.demo;
//Maan and Areebah

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelServiceApplication.class, args);
    }
}


