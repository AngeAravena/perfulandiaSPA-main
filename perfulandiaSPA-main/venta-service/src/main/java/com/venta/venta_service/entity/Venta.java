package com.venta.venta_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;
    private double precio;
    private double total;
    private String estado;
    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @PrePersist
    public void asignarFechaVenta() {
        this.fechaVenta = LocalDateTime.now();
    }

    @PreUpdate
    public void actualizarFechaVenta() {
        this.fechaVenta = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "envio_id")
    private Envio envio;
}
