package com.proveedor.proveedor_service.repository;

import com.proveedor.proveedor_service.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}