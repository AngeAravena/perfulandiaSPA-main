package com.perfulandia.envio.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String direccionDestino;
    private LocalDateTime fechaEnvio;
    private String estadoEnvio; //"Enviado", "En tránsito", "Entregado"

    @PrePersist
    public void asignarFechaEnvio() {
        this.fechaEnvio = LocalDateTime.now();
    }

    @PreUpdate
    public void actualizarFechaEnvio() {
        this.fechaEnvio = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
