package com.example.ratelimitterjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// A very simple implementation of a Rate Limitter

@SpringBootApplication
public class RateLimitterJavaApplication {

    public static void main(String[] args) {
        tokenInjector injector = new tokenInjector();
        injector.start();
        SpringApplication.run(RateLimitterJavaApplication.class, args);
    }

}
