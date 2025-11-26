package com.patrones.adapter;

/**
 * AddiAdapter
 * -----------
 * Integra la API Addi externa con nuestra interfaz MetodoPago. Traduce y
 * adapta los parámetros necesarios (ej.: genera un codigoOperacion y convierte tipos).
 */
public class AddiAdapter implements MetodoPago {

    private final AddiAPI addiApi;

    public AddiAdapter(AddiAPI addiApi) {
        this.addiApi = addiApi;
    }

    @Override
    public void procesarPago(double monto) {
        // AddiAPI espera float como monto y requiere un codigo de operacion
        String codigoOperacion = generarCodigoOperacion();
        String respuesta = addiApi.realizarCobro(addiApi.id(), codigoOperacion, (float) monto);
        if (respuesta != null && respuesta.startsWith("COBRO_OK")) {
            System.out.println("[AddiAdapter] Pago via Addi exitoso. Monto: $" + String.format("%.2f", monto) + " (Código: " + codigoOperacion + ")");
        } else {
            System.out.println("[AddiAdapter] Pago via Addi fallido. Respuesta: " + respuesta);
        }
    }

    private String generarCodigoOperacion() {
        // Simple ejemplo: en un caso real, se usaría un generador robusto
        return "ADDI-OP-" + System.currentTimeMillis();
    }

    @Override
    public String obtenerNombre() {
        return "Addi (Adapter)";
    }
}
