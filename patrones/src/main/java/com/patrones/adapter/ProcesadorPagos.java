package com.pagos.adapter;

/**
 * ProcesadorPagos
 * ---------------
 * Clase de alto nivel que depende solo de la abstracción MetodoPago (D). Su
 * responsabilidad es orquestar la ejecución de un pago suministrado como
 * dependencia (SRP). Gracias a la abstracción, podemos agregar nuevos
 * métodos de pago sin modificar esta clase (O).
 */
public class ProcesadorPagos {

    public void procesar(MetodoPago metodoPago, double monto) {
        System.out.println("-------------------------------------------");
        System.out.println("Procesador: Iniciando pago con método: " + metodoPago.obtenerNombre());
        metodoPago.procesarPago(monto);
        System.out.println("Procesador: Fin del pago con método: " + metodoPago.obtenerNombre());
        System.out.println("-------------------------------------------\n");
    }
}
