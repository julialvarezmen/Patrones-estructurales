package com.patrones.Decorator.Antipattern;

// Usamos la interfaz independiente para evitar conflictos
public class MalDecoradorPrecioFijo implements ProductoIndependiente {

    // Almacenamos la referencia de la interfaz independiente
    private ProductoIndependiente producto;

    public MalDecoradorPrecioFijo(ProductoIndependiente producto) {
        this.producto = producto;
    }

    @Override
    public double obtenerPrecio() {
        // !! ERROR! ESTO IGNORA la delegación y rompe la cadena de precios.
        System.out.println("<< ANTIPATRÓN: El decorador devuelve un precio fijo ($10.00) e ignora el producto envuelto. >>");

        // ¡El antipatrón devuelve un precio fijo, sin delegar!
        return 10.00;
    }

    @Override
    public String obtenerDescripcion() {
        // La descripción sí delega, mostrando que es un decorador
        return producto.obtenerDescripcion() + ", con FALLA DE PRECIO FIJO";
    }
}
