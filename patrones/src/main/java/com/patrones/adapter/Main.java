package com.pagos.adapter;

/**
 * Main
 * ----
 * Punto de entrada para ejecutar la demostración por terminal. Aquí se
 * crean implementaciones nativas y adaptadas, y se procesan pagos mostrando
 * en consola el flujo. Esto demuestra sustitución de Liskov: todas las
 * implementaciones son intercambiables donde se requiere MetodoPago.
 *
 * Ejecución por terminal (desde la raíz del proyecto):
 *   javac -d bin src/com/pagos/adapter/*.java
 *   java -cp bin com.pagos.adapter.Main
 */
public class Main {

    public static void main(String[] args) {
        ProcesadorPagos procesador = new ProcesadorPagos();

        // 1) Pago en efectivo
        MetodoPago efectivo = new PagoEfectivo();
        procesador.procesar(efectivo, 15000.0);

        // 2) Pago con tarjeta
        MetodoPago tarjeta = new PagoTarjeta("Juan Perez", "1234567890123456");
        procesador.procesar(tarjeta, 25990.50);

        // 3) Pago con Nequi (via adapter)
        NequiAPI nequiApi = new NequiAPI("+573001234567");
        MetodoPago nequiAdapter = new NequiAdapter(nequiApi);
        procesador.procesar(nequiAdapter, 10000.0);

        // 4) Pago con Addi (via adapter)
        AddiAPI addiApi = new AddiAPI(42, "Laura Gomez");
        MetodoPago addiAdapter = new AddiAdapter(addiApi);
        procesador.procesar(addiAdapter, 45999.99);

        // Demostración: podemos agregar un nuevo metodo de pago (abierto/cerrado)
        // sin tocar ProcesadorPagos ni los adaptadores existentes.

        System.out.println("Demostración finalizada. Todos los pagos fueron procesados.");
    }
}
