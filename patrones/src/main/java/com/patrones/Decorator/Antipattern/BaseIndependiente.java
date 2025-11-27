package com.patrones.Decorator.Antipattern;

// Simulación de la Camisa o Producto base
public class BaseIndependiente implements ProductoIndependiente {
    private String descripcion;
    private double costo;

    public BaseIndependiente(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    @Override
    public double obtenerPrecio() {
        return costo;
    }

    @Override
    public String obtenerDescripcion() {
        return descripcion;
    }
}
