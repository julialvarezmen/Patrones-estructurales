package com.patrones.Decorator;

/**
 * Decorador EmbalajeDeLujo: añade embalaje de lujo al producto.
 * Incrementa el precio en 8.00 y añade descripción.
 */
public class EmbalajeDeLujo extends com.patrones.Decorator.DecoradorProductoBase {
    private static final double COSTO_ADICIONAL = 8.00;
    private static final String DESCRIPCION_ADICIONAL = ", con Embalaje de Lujo";

    /**
     * Constructor que especifica el producto a decorar con embalaje de lujo.
     * @param productoDecorado el producto que recibirá el embalaje
     */
    public EmbalajeDeLujo(com.patrones.Decorator.IProducto productoDecorado) {
        super(productoDecorado);
    }

    @Override
    public double obtenerPrecio() {
        return productoDecorado.obtenerPrecio() + COSTO_ADICIONAL;
    }

    @Override
    public String obtenerDescripcion() {
        return productoDecorado.obtenerDescripcion() + DESCRIPCION_ADICIONAL;
    }
}