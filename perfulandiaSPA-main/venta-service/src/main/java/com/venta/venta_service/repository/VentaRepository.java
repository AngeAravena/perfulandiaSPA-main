package com.venta.venta_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.venta.venta_service.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
