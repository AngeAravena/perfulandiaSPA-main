package com.proveedor.proveedor_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProveedorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProveedorServiceApplication.class, args);
        System.out.println("Microservicio: PROVEEDOR\nrunning on port 8084...");
	}

}
