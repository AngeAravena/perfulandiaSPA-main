package com.perfulandia.logistica.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.logistica.model.Envio;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
    
    //metodo buscar envio por estado
    List<Envio> findByEstadoEnvio(String estadoEnvio);
    
    // Método buscar envíos por proveedor
    List<Envio> findByProveedor(String proveedor);
    
    // Método buscar envíos por cliente
    List<Envio> findByUsuarioId(Long usuarioId);
    
    // Método buscar envíos por fecha de envío
    List<Envio> findByFechaEnvioBetween(LocalDateTime startDate, LocalDateTime endDate);
}