package com.patrones.Decorator.Antipattern;

public class DemoAntipatron {
    public static void main(String[] args) {

        // 1. Crear el producto base independiente (precio de $35.00)
        ProductoIndependiente productoBase = new BaseIndependiente("Artículo Base de Prueba (Precio Original: $35.00)", 35.00);
        System.out.println("--- Producto Base Independiente ---");
        System.out.println("Descripción: " + productoBase.obtenerDescripcion());
        System.out.println("Precio Esperado: $" + productoBase.obtenerPrecio());

        // 2. Instanciar el MalDecoradorPrecioFijo con el producto independiente
        MalDecoradorPrecioFijo malDecorador = new MalDecoradorPrecioFijo(productoBase);

        System.out.println("\n--- Ejecutando Antipatrón ---");

        // 3. Ejecutar y demostrar el antipatrón
        double precioAntipatron = malDecorador.obtenerPrecio();

        // El resultado esperado es $10.00, ignorando los $35.00
        System.out.println("Precio Obtenido con MalDecorador: $" + precioAntipatron);
        System.out.println("Descripción Final: " + malDecorador.obtenerDescripcion());
        System.out.println("-----------------------------");
    }
}