package com.perfulandia.venta.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ventaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cliente_id", nullable = false)
    private String clienteId;
    
    @Column(name = "producto_id", nullable = false)
    private String productoId;
    
    @Column(nullable = false)
    private Integer cantidad;
    
    @Column(nullable = false)
    private Double precio;
    
    @Column(nullable = false)
    private Double total;
    
    @Column(nullable = false)
    private String estado = "PENDIENTE"; // PENDIENTE, COMPLETADA, CANCELADA
    
    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta = LocalDateTime.now();
    
    @PrePersist
    public void calcularTotal() {
        if (cantidad != null && precio != null) {
            this.total = cantidad * precio;
        }
        if (fechaVenta == null) {
            this.fechaVenta = LocalDateTime.now();
        }
    }
    
    @PreUpdate
    public void actualizarTotal() {
        if (cantidad != null && precio != null) {
            this.total = cantidad * precio;
        }
    }
}