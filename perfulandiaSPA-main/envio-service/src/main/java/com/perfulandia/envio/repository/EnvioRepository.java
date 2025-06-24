package com.perfulandia.envio.repository;

import com.perfulandia.envio.entity.Envio;
import com.perfulandia.envio.entity.Proveedor;
import com.perfulandia.envio.entity.Usuario;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnvioRepository extends JpaRepository<Envio, Long> {

    
    List<Envio> findByProveedor(Proveedor proveedor);
    
    List<Envio> findByEstadoEnvio(String estadoEnvio);
    
    
    List<Envio> findByUsuario(Usuario usuario);

    List<Envio> findByFechaEnvioBetween(LocalDateTime start, LocalDateTime end);
        
}