package com.pagos.adapter;

/**
 * Interfaz MetodoPago
 * -------------------
 * Interfaz mínima y coherente que representa un método de pago en nuestro
 * sistema (principio de segregación de interfaces - I). Solo expone
 * operaciones esenciales:
 *   - procesarPago(double monto)
 *   - obtenerNombre()
 *
 * Con esta interfaz el ProcesadorPagos depende únicamente de la abstracción
 * (principio de inversión de dependencias - D).
 */
public interface MetodoPago {

    /**
     * Procesa un pago del monto indicado. Implementaciones concretas harán
     * la lógica correspondiente (efectivo, tarjeta, o adaptadores para APIs externas).
     */
    void procesarPago(double monto);

    /**
     * Devuelve un nombre legible del método de pago.
     */
    String obtenerNombre();
}
