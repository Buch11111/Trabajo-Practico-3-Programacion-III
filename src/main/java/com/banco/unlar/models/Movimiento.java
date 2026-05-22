package com.banco.unlar.models;

import java.time.LocalDateTime;

/**
 * Clase que representa un Movimiento (ej: un depósito o extracción).
 * En la vida real, un movimiento no puede existir sin una Cuenta.
 * Por eso, en la clase Cuenta usaremos "Composición" para guardar una lista de estos.
 */
public class Movimiento {
    
    // Atributos privados: solo se pueden modificar desde esta clase
    private LocalDateTime fecha;
    private double monto;
    private String detalle;

    // Constructor vacío (necesario a veces para frameworks como Spring)
    public Movimiento() {
    }

    // Constructor con parámetros: nos permite crear un Movimiento pasándole los datos iniciales
    public Movimiento(LocalDateTime fecha, double monto, String detalle) {
        this.fecha = fecha;
        this.monto = monto;
        this.detalle = detalle;
    }

    // Getters (para leer los datos) y Setters (para modificar los datos)
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
