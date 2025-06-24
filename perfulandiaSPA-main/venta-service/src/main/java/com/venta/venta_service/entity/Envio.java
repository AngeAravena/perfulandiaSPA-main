package com.venta.venta_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {

    @Id
    private Long Id;

    private String direccionDestino;
    private LocalDateTime fechaEnvio;
    private String estadoEnvio; //"Enviado", "En tránsito", "Entregado"
    private String proveedor; // Nombre del proveedor de envío
    private Long usuarioId; // ID del cliente asociado al envío
    
}
