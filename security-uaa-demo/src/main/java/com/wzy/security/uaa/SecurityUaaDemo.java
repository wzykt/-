package com.wzy.security.uaa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
@EnableFeignClients(basePackages = "com.wzy.security.uaa")
public class SecurityUaaDemo {
    public static void main(String[] args) {
        SpringApplication.run(SecurityUaaDemo.class, args);
    }
}
