package com.perfulandia.envio.dto;

import com.perfulandia.envio.entity.Proveedor;
import com.perfulandia.envio.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnvioDTO {
    private Long id;
    private String direccionDestino;
    private String estadoEnvio;
    private LocalDateTime fechaEnvio;
    private Proveedor proveedor;
    private Usuario usuario;
}