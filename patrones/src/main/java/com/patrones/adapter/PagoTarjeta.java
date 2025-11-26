package com.pagos.adapter;

/**
 * PagoTarjeta
 * -----------
 * Implementación nativa que representa un pago con tarjeta de crédito/débito.
 */
public class PagoTarjeta implements MetodoPago {

    private final String titular;
    private final String numeroTarjeta;
    private final String nombre;

    public PagoTarjeta(String titular, String numeroTarjeta) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.nombre = "Tarjeta (****" + pacienteUltimos4(numeroTarjeta) + ")";
    }

    private String pacienteUltimos4(String numero) {
        if (numero == null || numero.length() < 4) return "----";
        return numero.substring(numero.length() - 4);
    }

    @Override
    public void procesarPago(double monto) {
        // Validación mínima (ejemplo simple); en un caso real se haría llamada a pasarela
        System.out.println("[PagoTarjeta] Procesando pago de $" + String.format("%.2f", monto) + " con tarjeta de " + titular);
        if (numeroTarjeta == null || numeroTarjeta.trim().isEmpty()) {
            System.out.println("[PagoTarjeta] Error: número de tarjeta inválido.");
            return;
        }
        System.out.println("[PagoTarjeta] Confirmación: Pago hecho exitosamente con tarjeta. Autorización: 123456");
    }

    @Override
    public String obtenerNombre() {
        return nombre;
    }
}
