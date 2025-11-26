package com.patrones.Decorator;

/**
 * Clase abstracta DecoradorProductoBase: implementa el patrón Decorator.
 * Contiene una referencia a un IProducto y delega las llamadas a sus métodos.
 * Los decoradores concretos heredarán de esta clase y sobrescribirán el comportamiento.
 */
public abstract class DecoradorProductoBase implements IProducto {
    // Referencia al objeto siendo decorado
    protected IProducto productoDecorado;
    
    /**
     * Constructor que acepta el producto a decorar.
     * @param productoDecorado el producto que será decorado
     */
    public DecoradorProductoBase(IProducto productoDecorado) {
        this.productoDecorado = productoDecorado;
    }
    
    /**
     * Delega la llamada al producto decorado.
     * Los decoradores concretos pueden sobrescribir este método.
     */
    @Override
    public double obtenerPrecio() {
        return productoDecorado.obtenerPrecio();
    }
    
    /**
     * Delega la llamada al producto decorado.
     * Los decoradores concretos pueden sobrescribir este método.
     */
    @Override
    public String obtenerDescripcion() {
        return productoDecorado.obtenerDescripcion();
    }
}
