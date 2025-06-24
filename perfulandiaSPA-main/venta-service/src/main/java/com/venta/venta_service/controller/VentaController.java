package com.venta.venta_service.controller;

import com.venta.venta_service.entity.Venta;
import com.venta.venta_service.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public Venta crearVenta(@RequestBody Venta venta) {
        return ventaService.crearVenta(venta);
    }

    @GetMapping
    public List<Venta> obtenerTodasLasVentas() {
        return ventaService.obtenerTodasLasVentas();
    }

    @GetMapping("/{id}")
    public Optional<Venta> obtenerVentaPorId(@PathVariable Long id) {
        return ventaService.obtenerVentaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
    }
}
