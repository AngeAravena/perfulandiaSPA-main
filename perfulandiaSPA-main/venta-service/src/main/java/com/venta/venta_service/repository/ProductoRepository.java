package com.venta.venta_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.venta.venta_service.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}


