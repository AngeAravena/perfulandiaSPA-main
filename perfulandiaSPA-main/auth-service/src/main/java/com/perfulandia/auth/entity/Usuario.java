package com.perfulandia.auth.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //anotattion, crea la tabla usuario
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ID autoincremental

    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    public Usuario() {} //Constructor para jpa

    //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
