package com.perfulandia.envio.service;


import java.time.LocalDateTime;
import java.util.List;
import com.perfulandia.envio.entity.Proveedor;
import com.perfulandia.envio.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.perfulandia.envio.dto.EnvioDTO;
import com.perfulandia.envio.entity.Envio;
import com.perfulandia.envio.repository.EnvioRepository;
import com.perfulandia.envio.repository.ProveedorRepository;
import com.perfulandia.envio.repository.UsuarioRepository;


@Service
public class EnvioService {


    public String obtenerPedido(Long idProveedor) {
        String url = "http://localhost:8084/api/proveedor/" + idProveedor;
        return restTemplate.getForObject(url, String.class);
    } //Inyecta RestTemplate para consultar un pedido por ID del microservicio de ventas

    @Value("${usuarios.service.url}")
    private String usuariosServiceUrl;
@Autowired
private ProveedorRepository proveedorRepository;

@Autowired
private UsuarioRepository usuarioRepository;

public Envio crearEnvio(Envio envio) {
    // Si solo viene el id, busca el objeto completo
    if (envio.getProveedor() != null && envio.getProveedor().getId() != null) {
        Proveedor proveedorCompleto = proveedorRepository.findById(envio.getProveedor().getId()).orElse(null);
        envio.setProveedor(proveedorCompleto);
    }
    if (envio.getUsuario() != null && envio.getUsuario().getId() != null) {
        Usuario usuarioCompleto = usuarioRepository.findById(envio.getUsuario().getId()).orElse(null);
        envio.setUsuario(usuarioCompleto);
    }
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

public List<Envio> buscarEnviosPorProveedor(Proveedor proveedor) {
    return envioRepository.findByProveedor(proveedor);
}

    public List<Envio> buscarEnviosPorCliente(Usuario usuarioId) {
        return envioRepository.findByUsuario(usuarioId);
    }

public List<Envio> buscarEnviosPorFecha(LocalDateTime start, LocalDateTime end) {
    return envioRepository.findByFechaEnvioBetween(start, end);
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

public boolean eliminarEnvio(Long id) {
    if (envioRepository.existsById(id)) {
        envioRepository.deleteById(id);
        return true;
    }
    return false;
}




@Autowired
private EnvioRepository envioRepository;





@Autowired
private RestTemplate restTemplate;

@Value("${proveedor.service.url}")
private String proveedorServiceUrl;

public EnvioDTO obtenerEnvioPorId(Long id) {
    Envio envio = envioRepository.findById(id).orElse(null);
    if (envio == null) return null;

    EnvioDTO dto = new EnvioDTO();
    dto.setId(envio.getId());
    dto.setDireccionDestino(envio.getDireccionDestino());
    dto.setEstadoEnvio(envio.getEstadoEnvio());
    dto.setFechaEnvio(envio.getFechaEnvio());
    dto.setUsuario(envio.getUsuario());

    // Aquí obtienes el proveedor completo por REST
    if (envio.getProveedor() != null && envio.getProveedor().getId() != null) {
        Proveedor proveedor = restTemplate.getForObject(
            proveedorServiceUrl + envio.getProveedor().getId(), Proveedor.class);
        dto.setProveedor(proveedor);
    }

    return dto;
}

}
