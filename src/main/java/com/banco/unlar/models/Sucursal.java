package com.banco.unlar.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa la Sucursal de un Banco.
 */
public class Sucursal {
    private Long id;
    private String nombre;
    private String direccion;
    
    // AGREGACIÓN: Una Sucursal "agrupa" Clientes. 
    // Es agregación porque si cerramos la sucursal, el Cliente sigue existiendo.
    private List<Cliente> clientes;

    public Sucursal() {
        this.clientes = new ArrayList<>();
    }

    public Sucursal(Long id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.clientes = new ArrayList<>();
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
