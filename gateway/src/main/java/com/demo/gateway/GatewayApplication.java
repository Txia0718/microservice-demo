package com.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    static void main(String[] args) {
        System.setProperty("csp.sentinel.app.type", "11");
        SpringApplication.run(GatewayApplication.class, args);
    }
}
