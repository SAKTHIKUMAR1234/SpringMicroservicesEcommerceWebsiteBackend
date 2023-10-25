package com.example.ecommerceserver.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortConfig {

    @Value("${server.port:8080}")
    private int eurekaServerPort;

    public int getEurekaServerPort() {
        return eurekaServerPort;
    }
}
