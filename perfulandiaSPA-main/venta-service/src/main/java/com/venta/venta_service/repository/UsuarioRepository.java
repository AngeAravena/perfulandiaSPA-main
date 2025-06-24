package com.venta.venta_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.venta.venta_service.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

