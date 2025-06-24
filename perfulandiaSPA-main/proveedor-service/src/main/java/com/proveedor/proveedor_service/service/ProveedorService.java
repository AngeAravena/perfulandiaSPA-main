package com.proveedor.proveedor_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proveedor.proveedor_service.entity.Proveedor;
import com.proveedor.proveedor_service.repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor getProveedorById(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void deleteProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }

    public Proveedor actualizar(Long id, Proveedor actualizado) {
        return proveedorRepository.findById(id).map(p -> {
            p.setNombre(actualizado.getNombre());
            p.setTelefono(actualizado.getTelefono());
            return proveedorRepository.save(p);
        }).orElse(null);
    }

}
