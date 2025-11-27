package com.patrones.Decorator;

/*
 * Interfaz que define el contrato para los productos.
 * Tanto las clases concretas como los decoradores implementan esta interfaz.
 */
public interface IProducto {
    /*
     * Retorna el precio del producto (incluyendo decoradores).
     * @return precio en formato double
     */
    double obtenerPrecio();

    /*
     * Retorna la descripción del producto (incluyendo decoradores).
     * @return descripción en formato String
     */
    String obtenerDescripcion();
}