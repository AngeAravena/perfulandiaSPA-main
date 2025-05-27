package com.perfulandia.auth.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.perfulandia.auth.entity.Usuario;
import com.perfulandia.auth.repository.UsuarioRepository;


public class UsuarioService {


    @Autowired  //inyección de dependencia
                // Inyecta el repositorio de usuario para poder interactuar con la base de datos
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {
                if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Ya existe un usuario con ese email");
        }else{
                // Solo si el usuario no existe, lo guardamos
                // Sé que el else es redundante por la funcion del throw, pero considero que es una buena práctica para alguien novato
            return usuarioRepository.save(usuario);
            }

    }

        // Actualiza usuario por id
        // compara el id existente con el id del nuevo usuario
        // si no son iguales o no existe el id en la tabla, lanza una excepción
    public Usuario actualizarUsuario(Long id, Usuario nuevoUsuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado o no existe"));

        usuarioExistente.setNombre(nuevoUsuario.getNombre());
        usuarioExistente.setApellido(nuevoUsuario.getApellido());
        usuarioExistente.setEmail(nuevoUsuario.getEmail());

        return usuarioRepository.save(usuarioExistente);
        // guarda el usuario con los datos del argumento usuarioExistente
        // se debe tener una validación de que el id del usuario existe en la tabla
        // de lo contrario, hibernate tomará el id del nuevo usuario y lo guardará como un nuevo registro
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Elimina usuario por id
    public void eliminarUsuario(Long id) {

        // Verifica si el usuario existe antes de intentar eliminarlo
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe usuario con ese ID");
            // Si no existe, lanza una excepción
        }else{
            // Lo mismo, es redundancia porque el throw detiene la ejecución, pero es una buena práctica para alguien novato
            usuarioRepository.deleteById(id);
        }

    }

}
