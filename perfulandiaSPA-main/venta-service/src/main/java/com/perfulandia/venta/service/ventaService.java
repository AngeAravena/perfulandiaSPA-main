package com.perfulandia.venta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.perfulandia.venta.model.ventaModel;
import com.perfulandia.venta.repository.ventaRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ventaService {
    
    private final ventaRepository ventaRepository;

    public List<ventaModel> obtenerTodasLasVentas() {
        return ventaRepository.findAll();
    }

    public Optional<ventaModel> obtenerVentaPorId(Long id) {
        return ventaRepository.findById(id);
    }

    public ventaModel crearVenta(ventaModel venta) {
        return ventaRepository.save(venta);
    }

    public ventaModel actualizarVenta(Long id, ventaModel ventaActualizada) {
        if (ventaRepository.existsById(id)) {
            ventaActualizada.setId(id);
            return ventaRepository.save(ventaActualizada);
        }
        return null;
    }

    public boolean eliminarVenta(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<ventaModel> obtenerVentasPorCliente(String clienteId) {
        return ventaRepository.findByClienteId(clienteId);
    }

    public List<ventaModel> obtenerVentasPorEstado(String estado) {
        return ventaRepository.findByEstado(estado);
    }

    public ventaModel cambiarEstadoVenta(Long id, String nuevoEstado) {
        Optional<ventaModel> ventaOpt = ventaRepository.findById(id);
        if (ventaOpt.isPresent()) {
            ventaModel venta = ventaOpt.get();
            venta.setEstado(nuevoEstado);
            return ventaRepository.save(venta);
        }
        return null;
    }
}