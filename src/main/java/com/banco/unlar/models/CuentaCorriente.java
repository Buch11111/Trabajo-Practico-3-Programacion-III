package com.banco.unlar.models;

/**
 * Al igual que CajaAhorro, CuentaCorriente HEREDA de Cuenta.
 */
public class CuentaCorriente extends Cuenta {

    public CuentaCorriente() {
        super();
    }

    public CuentaCorriente(String cbu, double saldo) {
        super(cbu, saldo);
    }
}
