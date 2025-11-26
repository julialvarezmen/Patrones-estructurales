package com.patrones.Composite;

/**
 * ANTI-PATRÓN - LO QUE NO DEBES HACER
 * 
 * Este código muestra un enfoque ANTI-PATRÓN porque:
 * 1. No hay uniformidad entre objetos simples y compuestos
 * 2. Duplicación de código
 * 3. Dependencia fuerte entre clases
 * 4. Dificulta agregar nuevos tipos de elementos
 * 5. Violación del principio DRY (Don't Repeat Yourself)
 */

// Clase para productos - completamente independiente
class ProductoAntiPatron {
    private String nombre;
    private double precio;
    
    public ProductoAntiPatron(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void mostrarInfo() {
        System.out.println("  Producto: " + nombre + " - $" + precio);
    }
}

// Clase para cajas - TAMBIÉN independiente pero duplica lógica
class CajaAntiPatron {
    private String nombre;
    private java.util.List<ProductoAntiPatron> productos; // Solo puede tener productos
    private java.util.List<CajaAntiPatron> cajas; // Solo puede tener cajas
    
    public CajaAntiPatron(String nombre) {
        this.nombre = nombre;
        this.productos = new java.util.ArrayList<>();
        this.cajas = new java.util.ArrayList<>();
    }
    
    // Problema: Dos métodos separados para agregar
    public void agregarProducto(ProductoAntiPatron producto) {
        productos.add(producto);
    }
    
    public void agregarCaja(CajaAntiPatron caja) {
        cajas.add(caja);
    }
    
    // Problema: Cálculo complejo y repetitivo
    public double calcularPrecioTotal() {
        double total = 0;
        
        // Sumar productos
        for (ProductoAntiPatron producto : productos) {
            total += producto.getPrecio();
        }
        
        // Sumar cajas (recursivamente)
        for (CajaAntiPatron caja : cajas) {
            total += caja.calcularPrecioTotal(); // Recursión manual
        }
        
        return total;
    }
    
    // Problema: Lógica de mostrar duplicada y compleja
    public void mostrarTodo() {
        System.out.println("Caja: " + nombre + " (Total: $" + calcularPrecioTotal() + ")");
        
        // Mostrar productos
        for (ProductoAntiPatron producto : productos) {
            producto.mostrarInfo();
        }
        
        // Mostrar cajas (recursivamente)
        for (CajaAntiPatron caja : cajas) {
            caja.mostrarTodo(); // Recursión manual
        }
    }
}

// CLASE PRINCIPAL - Problemas evidentes
public class AntiPattern {
    public static void main(String[] args) {
        System.out.println("=== ANTI-PATRÓN ===\n");
        
        // Crear productos
        ProductoAntiPatron laptop = new ProductoAntiPatron("Laptop", 1200.0);
        ProductoAntiPatron mouse = new ProductoAntiPatron("Mouse", 25.0);
        
        // Crear cajas
        CajaAntiPatron cajaAccesorios = new CajaAntiPatron("Accesorios");
        cajaAccesorios.agregarProducto(mouse); // Método diferente para cada tipo
        
        CajaAntiPatron cajaPrincipal = new CajaAntiPatron("Paquete Completo");
        cajaPrincipal.agregarProducto(laptop);
        cajaPrincipal.agregarCaja(cajaAccesorios); // Método diferente
        
        // PROBLEMA 1: No podemos tratar Producto y Caja de la misma manera
        // procesar(laptop); // No funciona, necesita código específico
        // procesar(cajaPrincipal); // No funciona, necesita código específico
        
        // PROBLEMA 2: Necesitamos saber el tipo exacto antes de trabajar
        if (laptop instanceof ProductoAntiPatron) {
            System.out.println("Precio: $" + laptop.getPrecio());
        }
        
        // PROBLEMA 3: Si queremos agregar un nuevo tipo (ej: Servicio),
        // tendríamos que modificar la clase CajaAntiPatron para agregar:
        // - List<Servicio> servicios
        // - método agregarServicio()
        // - modificar calcularPrecioTotal()
        // - modificar mostrarTodo()
        // ¡Esto viola el principio abierto/cerrado!
        
        cajaPrincipal.mostrarTodo();
    }
    
    // PROBLEMA 4: Método genérico es imposible sin interfaces comunes
    // No podemos tener un método que procese tanto Producto como Caja
    // sin verificar tipos constantemente
}

