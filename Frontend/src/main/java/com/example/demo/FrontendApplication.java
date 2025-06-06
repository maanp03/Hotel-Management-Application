package com.example.demo;

//MAAN AND AREEBAH

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class FrontendApplication {
 public static void main(String[] args) {
     SpringApplication.run(FrontendApplication.class, args);
     
     
 }
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
 
}
