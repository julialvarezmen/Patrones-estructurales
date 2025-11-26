package com.patrones.Decorator;

/**
 * Clase Camisa: representa el componente base que será decorado.
 * Define un producto base con su precio y descripción iniciales.
 */
public class Camisa implements IProducto {
    private static final double PRECIO_BASE = 35.00;
    private static final String DESCRIPCION_BASE = "Camisa";
    
    @Override
    public double obtenerPrecio() {
        return PRECIO_BASE;
    }
    
    @Override
    public String obtenerDescripcion() {
        return DESCRIPCION_BASE;
    }
}
