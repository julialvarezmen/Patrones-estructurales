package com.patrones.adapter;

/**
 * AddiAPI (simulación de librería antigua/incompatible)
 * ----------------------------------------------------
 * Esta otra API externa usa una estructura diferente: requiere un ID de usuario
 * y códigos especiales para realizar cobros. El adaptador se encargará de
 * traducir esto a MetodoPago.
 */
public class AddiAPI {

    private final int idUsuario;
    private final String nombreCliente;

    public AddiAPI(int idUsuario, String nombreCliente) {
        this.idUsuario = idUsuario;
        this.nombreCliente = nombreCliente;
    }

    // Método incompatible: realizarCobro con tipos y nombres distintos
    public String realizarCobro(int usuarioId, String codigoOperacion, float monto) {
        System.out.println("[AddiAPI] Realizando cobro. UsuarioID: " + usuarioId + ", Código: " + codigoOperacion + ", Monto: $" + String.format("%.2f", monto));
        // Simulación: devuelve un string con estado
        return "COBRO_OK:" + codigoOperacion;
    }

    public String cliente() {
        return nombreCliente;
    }

    public int id() {
        return idUsuario;
    }
}
