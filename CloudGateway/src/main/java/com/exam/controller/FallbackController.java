package com.exam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/customerFallback")
    public Mono<String> customerServiceFallBack() {
        return Mono.just("Customer Service is taking too long to respond or is down. Please try again later");
    }
    
    @RequestMapping("/productFallback")
    public Mono<String> productServiceFallBack() {
        return Mono.just("Product Service is taking too long to respond or is down. Please try again later");
    }
    
    @RequestMapping("/orderFallback")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order Service is taking too long to respond or is down. Please try again later");
    }
   
    
}
