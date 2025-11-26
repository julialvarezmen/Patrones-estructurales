package com.patrones.adapter;

/**
 * PagoEfectivo
 * ------------
 * Implementación nativa de un método de pago (efectivo). Responsabilidad única: representar y
 * procesar pagos en efectivo.
 */
public class PagoEfectivo implements MetodoPago {

    private final String nombre;

    public PagoEfectivo() {
        this.nombre = "Efectivo";
    }

    @Override
    public void procesarPago(double monto) {
        // Lógica simple y demostrativa
        System.out.println("[PagoEfectivo] Procesando pago en " + nombre + ": $" + String.format("%.2f", monto));
        System.out.println("[PagoEfectivo] Confirmación: Pago en efectivo recibido.");
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }
}
