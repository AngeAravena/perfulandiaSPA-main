package com.perfulandia.envio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.envio.dto.EnvioDTO;
import com.perfulandia.envio.entity.Envio;
import com.perfulandia.envio.service.EnvioService;


@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;
    
    @PostMapping
    public Envio crearEnvio(@RequestBody Envio envio) {
        return envioService.crearEnvio(envio);
    }

    @GetMapping
    public List<Envio> listarEnvios() {
        return envioService.listarEnvios();
    }

    @GetMapping("/usuarios")
public ResponseEntity<String> obtenerTodosLosUsuarios() {
    String usuarios = envioService.obtenerTodosLosUsuarios();
    return ResponseEntity.ok(usuarios);
}


    @GetMapping("/usuarios/{usuarioId}")
public ResponseEntity<String> obtenerUsuarioPorId(@PathVariable Long usuarioId) {
    String usuario = envioService.obtenerUsuarioPorId(usuarioId);
    if (usuario == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(usuario);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarEnvio(@PathVariable Long id) {
    boolean eliminado = envioService.eliminarEnvio(id);
    if (eliminado) {
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}

    @PostMapping("/{id}/actualizar")
    public Envio actualizarEnvio(@PathVariable Long id, @RequestBody Envio envioActualizado) {
        return envioService.actualizarEnvio(id, envioActualizado);
    }


@GetMapping("/{id}")
public ResponseEntity<EnvioDTO> buscarPorId(@PathVariable Long id) {
    EnvioDTO envio = envioService.obtenerEnvioPorId(id);
    if (envio == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(envio);
}



}
