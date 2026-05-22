package com.banco.unlar.models;

/**
 * CajaAhorro hereda ("extends") de Cuenta.
 * HERENCIA: CajaAhorro "es una" Cuenta. Hereda automáticamente su CBU, su saldo y sus movimientos.
 */
public class CajaAhorro extends Cuenta {
    
    public CajaAhorro() {
        // Llama al constructor vacío de la clase padre (Cuenta)
        super();
    }

    public CajaAhorro(String cbu, double saldo) {
        // Llama al constructor con parámetros de la clase padre (Cuenta)
        // y le pasa los valores para que los guarde.
        super(cbu, saldo);
    }
}
