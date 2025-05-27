package com.perfulandia.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.auth.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // método para buscar un usuario por email
    Usuario findByEmail(String email);

    // método para eliminar un usuario por email
    void deleteByEmail(String email);
    
    // Método para verificar si un usuario existe por email
    boolean existsByEmail(String email);
}
