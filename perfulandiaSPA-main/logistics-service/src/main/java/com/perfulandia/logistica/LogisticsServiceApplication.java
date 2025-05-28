package com.perfulandia.logistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LogisticsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsServiceApplication.class, args);
		System.out.println("Microservicio: LOGÍSTICA Y PEDIDOS\nrunning...");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
