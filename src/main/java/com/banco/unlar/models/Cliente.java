package com.banco.unlar.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un cliente del banco.
 */
public class Cliente {
    private String dni;
    private String nombre;
    private String email;
    
    // AGREGACIÓN: Un Cliente "tiene" Cuentas. 
    // Guardamos una lista con las cuentas que le pertenecen a esta persona.
    private List<Cuenta> cuentas;

    public Cliente() {
        // Siempre hay que inicializar las listas vacías para poder usarlas luego
        this.cuentas = new ArrayList<>();
    }

    public Cliente(String dni, String nombre, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.cuentas = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
}
