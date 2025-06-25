package com.venta.venta_service.controller;

import com.venta.venta_service.entity.Venta;
import com.venta.venta_service.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public EntityModel<Venta> crearVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.crearVenta(venta);
        return EntityModel.of(nuevaVenta,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VentaController.class).obtenerVentaPorId(nuevaVenta.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VentaController.class).obtenerTodasLasVentas()).withRel("all-ventas")
        );
    }

    @GetMapping
    public CollectionModel<EntityModel<Venta>> obtenerTodasLasVentas() {
        List<EntityModel<Venta>> ventas = ventaService.obtenerTodasLasVentas().stream()
                .map(venta -> EntityModel.of(venta,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VentaController.class).obtenerVentaPorId(venta.getId())).withSelfRel()))
                .collect(Collectors.toList());
        return CollectionModel.of(ventas,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VentaController.class).obtenerTodasLasVentas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Venta> obtenerVentaPorId(@PathVariable Long id) {
        Venta venta = ventaService.obtenerVentaPorId(id).orElseThrow();
        return EntityModel.of(venta,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VentaController.class).obtenerVentaPorId(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VentaController.class).obtenerTodasLasVentas()).withRel("all-ventas")
        ); //Agrega los links HATEOAS para la venta específica y todas las ventas
    }

    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
    }

    
}