package com.finance.creditms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CreditmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditmsApplication.class, args);
	}

}
