package com.patrones.Composite;

/**
 * EJEMPLO CON PATRÓN COMPOSITE
 * 
 * El patrón Composite permite tratar objetos individuales y grupos de objetos
 * de manera uniforme. Todos implementan la misma interfaz Component.
 */

// 1. INTERFAZ COMPONENT - Define la operación común
interface Component {
    String getName();
    double getPrice();
    void mostrar(); // Método común que todos deben implementar
}

// 2. LEAF - Hoja/Elemento individual (no tiene hijos)
class Producto implements Component {
    private String nombre;
    private double precio;
    
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    @Override
    public String getName() {
        return nombre;
    }
    
    @Override
    public double getPrice() {
        return precio;
    }
    
    @Override
    public void mostrar() {
        System.out.println("  Producto: " + nombre + " - Precio: $" + precio);
    }
}

// 3. COMPOSITE - Contenedor que puede tener hijos (otros Components)
class Caja implements Component {
    private String nombre;
    private java.util.List<Component> componentes; // Lista de hijos
    
    public Caja(String nombre) {
        this.nombre = nombre;
        this.componentes = new java.util.ArrayList<>();
    }
    
    // Métodos para agregar y quitar componentes
    public void agregar(Component componente) {
        componentes.add(componente);
    }
    
    public void remover(Component componente) {
        componentes.remove(componente);
    }
    
    @Override
    public String getName() {
        return nombre;
    }
    
    @Override
    public double getPrice() {
        // El precio de la caja es la suma de todos sus componentes
        double total = 0;
        for (Component componente : componentes) {
            total += componente.getPrice();
        }
        return total;
    }
    
    @Override
    public void mostrar() {
        System.out.println("Caja: " + nombre + " (Total: $" + getPrice() + ")");
        // Recursivamente muestra todos sus hijos
        for (Component componente : componentes) {
            componente.mostrar();
        }
    }
}

// 4. CLASE PRINCIPAL - Demostración del patrón
public class CompositeExample {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO CON PATRÓN COMPOSITE ===\n");
        
        // Crear productos individuales
        Component laptop = new Producto("Laptop", 1200.0);
        Component mouse = new Producto("Mouse", 25.0);
        Component teclado = new Producto("Teclado", 50.0);
        
        // Crear caja pequeña
        Caja cajaAccesorios = new Caja("Accesorios");
        cajaAccesorios.agregar(mouse);
        cajaAccesorios.agregar(teclado);
        
        // Crear caja grande que contiene todo
        Caja cajaPrincipal = new Caja("Paquete Completo");
        cajaPrincipal.agregar(laptop);
        cajaPrincipal.agregar(cajaAccesorios); // ¡Puede contener otra caja!
        
        // Lo más importante: tratamos todo uniformemente
        System.out.println("Precio del laptop: $" + laptop.getPrice());
        System.out.println("Precio de la caja de accesorios: $" + cajaAccesorios.getPrice());
        System.out.println("Precio de la caja principal: $" + cajaPrincipal.getPrice());
        System.out.println();
        
        // Mostrar todo el árbol de manera uniforme
        cajaPrincipal.mostrar();
    }
}

