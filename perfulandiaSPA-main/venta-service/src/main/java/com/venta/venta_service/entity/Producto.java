package com.venta.venta_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    
    @Id
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(length = 500)
    private String descripcion;
    @Column(nullable = false)
    private Double precio; 
    @Column(nullable = false)
    private int stock;
    @Column(nullable = false)
    private boolean estado;

}
