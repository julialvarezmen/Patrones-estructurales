package com.pagos.adapter;

/**
 * NequiAdapter
 * -------------
 * Este adaptador integra la API externa NequiAPI (incompatible) con nuestra
 * interfaz MetodoPago. Convierte las llamadas y parámetros entre ambos mundos.
 *
 * Aplicación del Patrón Adapter:
 *  - Adaptador implementa la interfaz objetivo (MetodoPago)
 *  - Internamente delega a la clase incompatible (NequiAPI)
 *  - Traduce/procesa valores/llamadas para que encajen con el contrato
 *
 * Con esto mantenemos el sistema abierto para nuevas integraciones (O), y el
 * ProcesadorPagos solo depende de la abstracción MetodoPago (D).
 */
public class NequiAdapter implements MetodoPago {

    private final NequiAPI nequiApi;

    public NequiAdapter(NequiAPI nequiApi) {
        this.nequiApi = nequiApi;
    }

    @Override
    public void procesarPago(double monto) {
        // Traducción: nuestra interfaz dice "procesarPago(monto)", pero
        // NequiAPI tiene "enviarDinero(numeroDestino, cantidad)".
        String destino = nequiApi.obtenerNumero(); // usamos el número asociado
        boolean exito = nequiApi.enviarDinero(destino, monto);
        if (exito) {
            System.out.println("[NequiAdapter] Pago via Nequi exitoso. Monto: $" + String.format("%.2f", monto));
        } else {
            System.out.println("[NequiAdapter] Pago via Nequi fallido.");
        }
    }

    @Override
    public String obtenerNombre() {
        return "Nequi (Adapter)";
    }
}
