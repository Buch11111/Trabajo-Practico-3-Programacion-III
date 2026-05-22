package com.banco.unlar.models;

/**
 * Representa una terminal de Cajero Automático.
 */
public class CajeroAutomatico {
    private String ubicacion;

    public CajeroAutomatico() {
    }

    public CajeroAutomatico(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * DEPENDENCIA: El cajero "depende" de una Cuenta para funcionar en este momento.
     * Fíjate que el cajero NO guarda la cuenta como un atributo (como sí hacíamos con la Lista).
     * Solo la recibe prestada un rato como parámetro, hace lo que tiene que hacer, y se olvida.
     */
    public double consultarSaldo(Cuenta cuenta) {
        if (cuenta != null) {
            return cuenta.getSaldo(); // Usa la cuenta prestada para leer el saldo
        }
        return 0.0;
    }
}
