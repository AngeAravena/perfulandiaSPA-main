package com.perfulandia.envio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public Envio buscarPorId(@PathVariable Long id) {
        return envioService.obtenerEnvioPorId(id);
    }

    @GetMapping("/usuarios/{usuarioId}")
public ResponseEntity<String> obtenerUsuarioPorId(@PathVariable Long usuarioId) {
    String usuario = envioService.obtenerUsuarioPorId(usuarioId);
    if (usuario == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(usuario);
}



}
