package com.perfulandia.productos.service;

import java.util.List;

import com.perfulandia.productos.entity.ProductTable;

public interface ProductService {

ProductTable agregarProducto(ProductTable producto);

ProductTable buscarPorId(long id);

List<ProductTable> disponibilidadProducto(boolean estado);

ProductTable actualizarProducto(long id, ProductTable producto);

void eliminarProducto(long id);

List<ProductTable> mostrarTodo();


}



