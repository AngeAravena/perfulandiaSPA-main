package com.perfulandia.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfulandia.productos.entity.ProductTable;

@Repository
public interface ProductRepository extends JpaRepository<ProductTable, Long> {
    
    List<ProductTable> findByEstadoTrue();
    
    List<ProductTable> findByNombreContainingIgnoreCase(String nombre);
    
    List<ProductTable> findByPrecioBetween(Double precioMin, Double precioMax);
    
    List<ProductTable> findByStockGreaterThan(int stock);
    
    List<ProductTable> findByEstadoTrueAndStockGreaterThan(int stock);
    
    List<ProductTable> findByEstadoTrueOrderByPrecioAsc();
    
    List<ProductTable> findByEstadoTrueOrderByPrecioDesc();
}