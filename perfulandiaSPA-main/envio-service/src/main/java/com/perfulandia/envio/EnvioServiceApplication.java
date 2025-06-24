package com.perfulandia.envio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EnvioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvioServiceApplication.class, args);
		System.out.println("Microservicio: ENVIOS\nrunning on port 8083...");
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
