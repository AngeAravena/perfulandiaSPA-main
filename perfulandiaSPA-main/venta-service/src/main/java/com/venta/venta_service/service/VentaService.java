package com.venta.venta_service.service;

import com.venta.venta_service.repository.EnvioRepository;
import com.venta.venta_service.repository.UsuarioRepository;
import com.venta.venta_service.repository.ProductoRepository;

import com.venta.venta_service.entity.Envio;
import com.venta.venta_service.entity.Producto;
import com.venta.venta_service.entity.Usuario;
import com.venta.venta_service.entity.Venta;
import com.venta.venta_service.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;


    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnvioRepository envioRepository;

    public Venta crearVenta(Venta venta) {
    if (venta.getProducto() != null && venta.getProducto().getId() != null) {
        Producto producto = productoRepository.findById(venta.getProducto().getId()).orElse(null);
        venta.setProducto(producto);
    }
    if (venta.getUsuario() != null && venta.getUsuario().getId() != null) {
        Usuario usuario = usuarioRepository.findById(venta.getUsuario().getId()).orElse(null);
        venta.setUsuario(usuario);
    }
    if (venta.getEnvio() != null && venta.getEnvio().getId() != null) {
        Envio envio = envioRepository.findById(venta.getEnvio().getId()).orElse(null);
        venta.setEnvio(envio);
    }
    return ventaRepository.save(venta);
}

    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id);
    }

    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}

