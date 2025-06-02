package com.perfulandia.venta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.perfulandia.venta.model.ventaModel;
import com.perfulandia.venta.service.ventaService;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class ventaController {

    private final ventaService ventaService;

    @GetMapping
    public ResponseEntity<List<ventaModel>> obtenerTodasLasVentas() {
        List<ventaModel> ventas = ventaService.obtenerTodasLasVentas();
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ventaModel> obtenerVentaPorId(@PathVariable Long id) {
        Optional<ventaModel> venta = ventaService.obtenerVentaPorId(id);
        return venta.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<ventaModel>> obtenerVentasPorCliente(@PathVariable String clienteId) {
        List<ventaModel> ventas = ventaService.obtenerVentasPorCliente(clienteId);
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ventaModel>> obtenerVentasPorEstado(@PathVariable String estado) {
        List<ventaModel> ventas = ventaService.obtenerVentasPorEstado(estado);
        return ResponseEntity.ok(ventas);
    }

    @PostMapping
    public ResponseEntity<ventaModel> crearVenta(@RequestBody ventaModel venta) {
        ventaModel nuevaVenta = ventaService.crearVenta(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ventaModel> actualizarVenta(@PathVariable Long id, @RequestBody ventaModel venta) {
        ventaModel ventaActualizada = ventaService.actualizarVenta(id, venta);
        return ventaActualizada != null ? 
               ResponseEntity.ok(ventaActualizada) : 
               ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<ventaModel> cambiarEstadoVenta(@PathVariable Long id, @RequestParam String estado) {
        ventaModel ventaActualizada = ventaService.cambiarEstadoVenta(id, estado);
        return ventaActualizada != null ? 
               ResponseEntity.ok(ventaActualizada) : 
               ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        boolean eliminado = ventaService.eliminarVenta(id);
        return eliminado ? 
               ResponseEntity.noContent().build() : 
               ResponseEntity.notFound().build();
    }
}