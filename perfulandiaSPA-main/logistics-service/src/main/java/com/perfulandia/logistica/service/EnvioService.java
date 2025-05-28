package com.perfulandia.logistica.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import com.perfulandia.logistica.model.Envio;
import com.perfulandia.logistica.repository.EnvioRepository;


@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

        @Autowired
    private RestTemplate restTemplate;

    public String obtenerPedido(Long idPedido) {
        String url = "http://localhost:8082/api/pedidos/" + idPedido;
        return restTemplate.getForObject(url, String.class);
    } //Inyecta RestTemplate para consultar un pedido por ID del microservicio de ventas

    @Value("${usuarios.service.url}")
        private String usuariosServiceUrl;
    

public Envio crearEnvio(Envio envio) {
    envio.setEstadoEnvio("EN_PREPARACION");
    return envioRepository.save(envio);
}

public Envio actualizarEnvio(Long id, Envio envioActualizado) {
    return envioRepository.findById(id).map(envio -> {
        envio.setEstadoEnvio(envioActualizado.getEstadoEnvio());
        envio.setFechaEnvio(envioActualizado.getFechaEnvio());
        envio.setProveedor(envioActualizado.getProveedor());
        return envioRepository.save(envio);
    }).orElse(null);
    }

    public List<Envio> listarEnvios() {
        return envioRepository.findAll();
    }

    public List<Envio> buscarEnviosPorEstado(String estadoEnvio) {
        return envioRepository.findByEstadoEnvio(estadoEnvio);
    }

    public List<Envio> buscarEnviosPorProveedor(String proveedor) {
        return envioRepository.findByProveedor(proveedor);
    }

    public List<Envio> buscarEnviosPorCliente(Long usuarioId) {
        return envioRepository.findByUsuarioId(usuarioId);
    }

    public List<Envio> buscarEnviosPorFecha(LocalDateTime startDate, LocalDateTime endDate) {
        return envioRepository.findByFechaEnvioBetween(startDate, endDate);
    }

    public Envio obtenerEnvioPorId(Long id) {
        return envioRepository.findById(id).orElse(null);
    }

    public Envio actualizarEstadoEnvio(Long id, String nuevoEstado) {
        return envioRepository.findById(id).map(envio -> {
            envio.setEstadoEnvio(nuevoEstado);
            return envioRepository.save(envio);
        }).orElse(null);
    }

    public String obtenerUsuarioPorId(Long usuarioId) {
    String url = usuariosServiceUrl + "/" + usuarioId;
    return restTemplate.getForObject(url, String.class);
}   // Método para consultar toda la informacion de un usuario por ID desde el microservicio de ventas


    public String obtenerTodosLosUsuarios() {
    return restTemplate.getForObject(usuariosServiceUrl, String.class);
}   // lo mismo pero lista todos los usuarios, garantiza la comunicacion entre microservicios






}
