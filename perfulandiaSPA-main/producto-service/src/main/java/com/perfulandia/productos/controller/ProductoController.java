package com.perfulandia.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfulandia.productos.entity.ProductTable;
import com.perfulandia.productos.service.ProductService;

@RestController
@RequestMapping("/api/producto") //Siempre una diagonal para que la ruta funcione
public class ProductoController {
    @Autowired
    private ProductService productosService;

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<ProductTable> crearProducto(@RequestBody ProductTable producto) {
        try {
            ProductTable nuevoProducto = productosService.agregarProducto(producto);
            return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<List<ProductTable>> obtenerTodosLosProductos() {
        try {
            List<ProductTable> productos = productosService.mostrarTodo();
            if (productos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductTable> obtenerProductoPorId(@PathVariable long id) {
        try {
            ProductTable producto = productosService.buscarPorId(id);
            if (producto != null) {
                return new ResponseEntity<>(producto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<ProductTable> actualizarProducto(@PathVariable long id, @RequestBody ProductTable producto) {
        try {
            ProductTable productoExistente = productosService.buscarPorId(id);
            if (productoExistente != null) {
                ProductTable productoActualizado = productosService.actualizarProducto(id, producto);
                return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarProducto(@PathVariable long id) {
        try {
            ProductTable producto = productosService.buscarPorId(id);
            if (producto != null) {
                productosService.eliminarProducto(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener productos disponibles (estado = true)
    @GetMapping("/disponibles")
    public ResponseEntity<List<ProductTable>> obtenerProductosDisponibles() {
        try {
            List<ProductTable> productosDisponibles = productosService.disponibilidadProducto(true);
            if (productosDisponibles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productosDisponibles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}





