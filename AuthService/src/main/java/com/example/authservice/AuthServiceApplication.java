package com.example.authservice;

import com.example.authservice.DAO.UserDAO;
import com.example.authservice.Entity.UsersEntity;
import com.example.authservice.Service.AdminCreationService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class AuthServiceApplication {

    private final AdminCreationService adminCreationService;

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @PostConstruct
    public void init(){
        adminCreationService.createAdmin();
    }

}
