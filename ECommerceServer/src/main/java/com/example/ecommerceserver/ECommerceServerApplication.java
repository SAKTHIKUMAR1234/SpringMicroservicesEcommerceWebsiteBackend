package com.example.ecommerceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class ECommerceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceServerApplication.class, args);
    }

}
