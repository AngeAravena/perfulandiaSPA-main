package com.perfulandia.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.auth.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmailContainingIgnoreCase(String email);

    void deleteByEmailContainingIgnoreCase(String email);
    
    boolean existsByEmailContainingIgnoreCase(String email);
}
