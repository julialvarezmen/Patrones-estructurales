package com.patrones.adapter;

/**
 * NequiAPI (simulación de librería antigua/incompatible)
 * ----------------------------------------------------
 * Esta API externa tiene una interfaz incompatible con MetodoPago: sus
 * métodos usan nombres distintos y parámetros diferentes. El objetivo es
 * que un adaptador convierta estas llamadas a nuestra interfaz común.
 */
public class NequiAPI {

    private final String numeroCelular;

    public NequiAPI(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    // API incompatible: en vez de procesar "pago" se usa "enviarDinero"
    public boolean enviarDinero(String numeroDestino, double cantidad) {
        System.out.println("[NequiAPI] Enviando dinero a " + numeroDestino + ": $" + String.format("%.2f", cantidad));
        // Simulación: siempre retorna true en esta demo
        return true;
    }

    // Método que no existe en Interface MetodoPago, con distinto nombre
    public String obtenerNumero() {
        return numeroCelular;
    }
}
