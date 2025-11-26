package com.patrones.Composite;

/**
 * EJEMPLO SIN PATRÓN COMPOSITE
 * 
 * Esta versión NO usa el patrón Composite. En su lugar, usa herencia
 * y verificación de tipos para manejar la estructura jerárquica.
 * 
 * PUNTO CLAVE: Aquí necesitamos saber si un elemento es Producto o Caja
 * antes de tratarlo, lo cual rompe la uniformidad.
 */

// Clase base usando herencia (no interfaz común)
abstract class ElementoInventario {
    protected String nombre;
    
    public ElementoInventario(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    // Métodos abstractos que cada clase debe implementar
    public abstract double calcularPrecio();
    public abstract void mostrarContenido();
}

// Producto individual
class ProductoSinComposite extends ElementoInventario {
    private double precio;
    
    public ProductoSinComposite(String nombre, double precio) {
        super(nombre);
        this.precio = precio;
    }
    
    @Override
    public double calcularPrecio() {
        return precio;
    }
    
    @Override
    public void mostrarContenido() {
        System.out.println("  Producto: " + nombre + " - Precio: $" + precio);
    }
}

// Caja contenedora
class CajaSinComposite extends ElementoInventario {
    private java.util.List<ElementoInventario> elementos;
    
    public CajaSinComposite(String nombre) {
        super(nombre);
        this.elementos = new java.util.ArrayList<>();
    }
    
    public void agregar(ElementoInventario elemento) {
        elementos.add(elemento);
    }
    
    public void remover(ElementoInventario elemento) {
        elementos.remove(elemento);
    }
    
    @Override
    public double calcularPrecio() {
        double total = 0;
        for (ElementoInventario elemento : elementos) {
            total += elemento.calcularPrecio();
        }
        return total;
    }
    
    @Override
    public void mostrarContenido() {
        System.out.println("Caja: " + nombre + " (Total: $" + calcularPrecio() + ")");
        for (ElementoInventario elemento : elementos) {
            elemento.mostrarContenido();
        }
    }
}

// CLASE PRINCIPAL - Problema: necesitamos verificar tipos
public class WithoutComposite {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO SIN PATRÓN COMPOSITE ===\n");
        
        // Crear productos
        ElementoInventario laptop = new ProductoSinComposite("Laptop", 1200.0);
        ElementoInventario mouse = new ProductoSinComposite("Mouse", 25.0);
        ElementoInventario teclado = new ProductoSinComposite("Teclado", 50.0);
        
        // Crear caja
        CajaSinComposite cajaAccesorios = new CajaSinComposite("Accesorios");
        cajaAccesorios.agregar(mouse);
        cajaAccesorios.agregar(teclado);
        
        CajaSinComposite cajaPrincipal = new CajaSinComposite("Paquete Completo");
        cajaPrincipal.agregar(laptop);
        cajaPrincipal.agregar(cajaAccesorios);
        
        // PROBLEMA: Para trabajar con elementos, necesitamos verificar el tipo
        System.out.println("Precio del laptop: $" + laptop.calcularPrecio());
        
        // Si queremos agregar nuevos tipos, tendremos que modificar este código
        // No podemos tratar todo de manera uniforme sin verificar tipos
        procesarElemento(laptop);
        procesarElemento(cajaAccesorios);
        System.out.println();
        
        cajaPrincipal.mostrarContenido();
    }
    
    // MÉTODO PROBLEMÁTICO: Necesitamos verificar tipos
    public static void procesarElemento(ElementoInventario elemento) {
        // Necesitamos verificar si es Producto o Caja para hacer algo específico
        if (elemento instanceof ProductoSinComposite) {
            System.out.println("Es un producto individual");
        } else if (elemento instanceof CajaSinComposite) {
            System.out.println("Es una caja con " + 
                ((CajaSinComposite)elemento).calcularPrecio() + " de valor");
        }
        // Si agregamos un nuevo tipo, tenemos que modificar este método
    }
}

