package com.wzy.security.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SecurityOrderDemo {
    public static void main(String[] args) {
        SpringApplication.run(SecurityOrderDemo.class, args);
    }
}
