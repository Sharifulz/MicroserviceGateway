package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCustomerApplication.class, args);
	}
}
