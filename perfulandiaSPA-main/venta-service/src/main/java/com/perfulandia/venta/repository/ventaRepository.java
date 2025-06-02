package com.perfulandia.venta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.venta.model.ventaModel;

import java.util.List;

@Repository
public interface ventaRepository extends JpaRepository<ventaModel, Long> {
    List<ventaModel> findByClienteId(String clienteId);
    List<ventaModel> findByEstado(String estado);
    List<ventaModel> findByProductoId(String productoId);
}
