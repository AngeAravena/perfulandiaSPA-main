package com.perfulandia.auth.controller;

import com.perfulandia.auth.entity.Usuario;
import com.perfulandia.auth.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase es una API REST
@RequestMapping("/api/usuarios") // Define la ruta base de todos los endpoints de este controlador
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/{id}") // Put actualiza un recurso existente
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario nuevoUsuario) {
        return usuarioService.actualizarUsuario(id, nuevoUsuario);
    }   //@PathVariable indica que el id es un parámetro de la ruta URL
        //@RequestBody indica que el cuerpo de la petición contiene los datos del usuario a actualizar

    @GetMapping("/{id}") // Get obtiene un recurso por su ID
                         // eso lo diferencia del metodo listarUsuarios
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @DeleteMapping("/{id}") // Delete elimina un recurso por su ID
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }



}


