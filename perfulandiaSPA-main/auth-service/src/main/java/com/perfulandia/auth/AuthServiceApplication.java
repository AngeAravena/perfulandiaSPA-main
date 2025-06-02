package com.perfulandia.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // Esta anotación indica que es una aplicación Spring Boot
// Permite la configuración automática y el escaneo de componentes en el paquete actual y subpaquetes
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
        // Inicia la aplicación Spring Boot
        System.out.println("Microservicio: GESTIÓN USUARIOS Y AUTENTICACIÓN\nrunning on port 8080...");
    }
}
