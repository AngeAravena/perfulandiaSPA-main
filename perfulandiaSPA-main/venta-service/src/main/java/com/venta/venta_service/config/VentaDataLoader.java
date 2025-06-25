package com.venta.venta_service.config;

import com.venta.venta_service.entity.Producto;
import com.venta.venta_service.entity.Usuario;
import com.venta.venta_service.entity.Envio;
import com.venta.venta_service.repository.VentaRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import com.venta.venta_service.entity.Venta;

@Configuration
public class VentaDataLoader {

    @Bean
    public CommandLineRunner loadData(VentaRepository ventaRepository) {
        return args -> {

        ventaRepository.deleteAll();
        
            Faker faker = new Faker();

            for (int i = 0; i < 10; i++) {
                Venta venta = new Venta();
                venta.setCantidad(faker.number().numberBetween(1, 5));
                venta.setPrecio(faker.number().randomDouble(2, 1000, 5000));
                venta.setTotal(venta.getCantidad() * venta.getPrecio());
                venta.setEstado("Pagado");
                venta.setFechaVenta(LocalDateTime.now());

                Usuario usuario = new Usuario();
                usuario.setId(1L);
                venta.setUsuario(usuario);

                Producto producto = new Producto();
                producto.setId(1L);
                venta.setProducto(producto);

                Envio envio = new Envio();
                envio.setId(5L);
                venta.setEnvio(envio);

                ventaRepository.save(venta);
            }

            System.out.println("Ventas falsas generadas correctamente");
        };
    }
}

