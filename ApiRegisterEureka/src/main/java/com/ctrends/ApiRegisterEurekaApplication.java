package com.ctrends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ApiRegisterEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRegisterEurekaApplication.class, args);
	}

}
