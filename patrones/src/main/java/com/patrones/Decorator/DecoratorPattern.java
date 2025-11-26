package com.patrones.Decorator;

/**
 * Implementación del Patrón Decorator en Java
 * 
 * El patrón Decorator permite añadir responsabilidades a objetos dinámicamente,
 * proporcionando una alternativa flexible a la herencia para extender funcionalidad.
 * 
 * En este ejemplo, decoramos productos (Camisa) con características adicionales
 * (Bordado Personalizado y Embalaje de Lujo) que incrementan el precio y
 * enriquecen la descripción.
 */

/**
 * Clase DecoratorPattern: contiene la demostración del patrón Decorator.
 */
public class DecoratorPattern {
    
    /**
     * Método principal que demuestra el funcionamiento del patrón Decorator.
     * 
     * Flujo:
     * 1. Crea un producto base (Camisa)
     * 2. Muestra precio y descripción inicial
     * 3. Decora con Bordado Personalizado
     * 4. Decora con Embalaje de Lujo
     * 5. Muestra precio y descripción final
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("DEMOSTRACIÓN DEL PATRÓN DECORATOR EN JAVA");
        System.out.println("=".repeat(70));
        System.out.println();
        
        // Paso 1: Crear el componente base (Camisa)
        System.out.println("PASO 1: Instanciación del componente base");
        System.out.println("-".repeat(70));
        IProducto producto = new Camisa();
        
        // Paso 2: Mostrar información del producto base
        System.out.println("Producto base: " + producto.obtenerDescripcion());
        System.out.println("Precio base: $" + String.format("%.2f", producto.obtenerPrecio()));
        System.out.println();
        
        // Paso 3: Decorar con Bordado Personalizado
        System.out.println("PASO 2: Aplicar primer decorador (Bordado Personalizado)");
        System.out.println("-".repeat(70));
        producto = new BordadoPersonalizado(producto);
        System.out.println("Producto decorado: " + producto.obtenerDescripcion());
        System.out.println("Precio actual: $" + String.format("%.2f", producto.obtenerPrecio()));
        System.out.println();
        
        // Paso 4: Decorar con Embalaje de Lujo
        System.out.println("PASO 3: Aplicar segundo decorador (Embalaje de Lujo)");
        System.out.println("-".repeat(70));
        producto = new EmbalajeDeLujo(producto);
        System.out.println("Producto final: " + producto.obtenerDescripcion());
        System.out.println("Precio final: $" + String.format("%.2f", producto.obtenerPrecio()));
        System.out.println();
        
        // Paso 5: Resumen de costos
        System.out.println("RESUMEN DE COSTOS");
        System.out.println("-".repeat(70));
        System.out.println("Precio base (Camisa):              $35.00");
        System.out.println("Costo Bordado Personalizado:      +$15.00");
        System.out.println("Costo Embalaje de Lujo:           +$8.00");
        System.out.println("-".repeat(70));
        System.out.println("TOTAL:                            $" + String.format("%.2f", producto.obtenerPrecio()));
        System.out.println("=".repeat(70));
    }
}
