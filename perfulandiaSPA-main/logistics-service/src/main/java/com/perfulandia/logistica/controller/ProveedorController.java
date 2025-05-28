package com.perfulandia.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.logistica.model.Proveedor;
import com.perfulandia.logistica.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.getAllProveedores();
    }

    @GetMapping("/{id}")
    public Proveedor getProveedorById(Long id) {
        return proveedorService.getProveedorById(id);
    }

    @PostMapping
    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedorService.saveProveedor(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor actualizar(Long id, Proveedor actualizado) {
        return proveedorService.actualizar(id, actualizado);
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(Long id) {
        proveedorService.deleteProveedor(id);
    }

}
