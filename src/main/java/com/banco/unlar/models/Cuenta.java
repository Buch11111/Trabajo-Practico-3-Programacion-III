package com.banco.unlar.models;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase Cuenta es "abstracta", lo que significa que no podemos crear un objeto Cuenta suelto.
 * Solo podemos crear hijas de ella (CajaAhorro o CuentaCorriente).
 */
public abstract class Cuenta {
    private String cbu;
    private double saldo;
    
    // COMPOSICIÓN: Una Cuenta "está compuesta" por Movimientos.
    // Si la cuenta se elimina, sus movimientos también. 
    private List<Movimiento> movimientos;

    public Cuenta() {
        // MUY IMPORTANTE: Inicializamos la lista vacía para que no tire error (NullPointerException)
        // cuando queramos agregarle el primer movimiento.
        this.movimientos = new ArrayList<>();
    }

    public Cuenta(String cbu, double saldo) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.movimientos = new ArrayList<>(); // Inicializamos también acá
    }

    // Getters y Setters
    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
}
