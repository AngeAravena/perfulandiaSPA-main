package com.perfulandia.logistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.logistica.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    
}
