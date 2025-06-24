package com.venta.venta_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VentaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentaServiceApplication.class, args);
        System.out.println("Microservicio: VENTA\nrunning on port 8085...");
	}

}
