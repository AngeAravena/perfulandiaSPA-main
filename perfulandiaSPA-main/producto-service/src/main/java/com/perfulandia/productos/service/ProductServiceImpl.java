package com.perfulandia.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.productos.entity.ProductTable;
import com.perfulandia.productos.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productorepository;
    @Override
    public ProductTable agregarProducto(ProductTable producto){
        return productorepository.save(producto);
    }

    @Override
    public List<ProductTable> mostrarTodo(){
        return productorepository.findAll();
    }

    @Override
    public ProductTable buscarPorId(long id){
        return productorepository.findById(id).orElse(null);
                                
    }
        @Override
    public void eliminarProducto(long id){
        ProductTable productoEliminar = buscarPorId(id);
            productorepository.delete(productoEliminar);
        }
    
    @Override
    public List<ProductTable> disponibilidadProducto(boolean estado){
        return productorepository.findByEstadoTrue();
    }
    @Override
    public ProductTable actualizarProducto(long id, ProductTable producto){
        ProductTable productoanterior = buscarPorId(id);
        productoanterior.setNombre(producto.getNombre());
        productoanterior.setPrecio(producto.getPrecio());
        productoanterior.setDescripcion(producto.getDescripcion());
        productoanterior.setStock(producto.getStock());
        productoanterior.setEstado(producto.isEstado());
        return productorepository.save(productoanterior);
    }
}
