package com.patrones.proxy.Antipatron;

public class ProxyAntiPatron {
    /*
      CONTEXTO (en español y corto):
      - "Reporte financiero" = información sensible.
      - El Proxy funciona como "portero": revisa permiso y registra el acceso.
      - SIN Proxy, se crean 3 formas comunes de hacerlo mal (antipatrones).
     */

    // Usuario con permiso (muy simple)
    static class User {
        String name;
        boolean canViewReport;
        User(String name, boolean canViewReport) { this.name = name; this.canViewReport = canViewReport; }
    }

    // Datos sensibles (el "reporte")
    static class SensitiveFinancialData {
        void showReport() {
            System.out.println("📄 Reporte financiero (SENSIBLE)");
        }
    }

    public static void main(String[] args) {
        User userSinPermiso = new User("Juan", false);

        anti1_accesoDirecto(userSinPermiso);
        anti2_ifRegadoPorTodoLado(userSinPermiso);
        anti3_seguridadDentroDelDato(userSinPermiso);
    }

    // ==========================================================
    // ANTIPATRÓN #1: ACCESO DIRECTO (sin puerta)
    // ==========================================================
    static void anti1_accesoDirecto(User user) {
        System.out.println("\n#1 Acceso directo (sin puerta)");
        SensitiveFinancialData data = new SensitiveFinancialData();

        // Punto crítico:
        // Aquí NO se revisa permiso. Entonces cualquiera lo ve.
        data.showReport();

        // ¿Qué “se rompe”?
        // Se rompe la seguridad porque no existe ningún bloqueo.
    }

    // ==========================================================
    // ANTIPATRÓN #2: EL "IF" DE PERMISO LO PONEN EN CADA LADO
    // ==========================================================
    static void anti2_ifRegadoPorTodoLado(User user) {
        System.out.println("\n#2 Permiso regado por todo el sistema (copiar/pegar)");
        SensitiveFinancialData data = new SensitiveFinancialData();

        // (medio bien) aquí sí validan:
        if (user.canViewReport) {
            data.showReport();
            System.out.println("LOG: acceso de " + user.name);
        } else {
            System.out.println("Acceso denegado");
        }

        // Punto crítico:
        // Si alguien borra ese if (por error) o se le olvida ponerlo en otra pantalla,
        // entonces pasa esto y se rompe TODO:
        // data.showReport();  // <-- muestra sin permiso
    }

    // ==========================================================
    // ANTIPATRÓN #3: METER LA SEGURIDAD DENTRO DEL REPORTE
    // ==========================================================
    static void anti3_seguridadDentroDelDato(User user) {
        System.out.println("\n#3 Seguridad metida dentro del reporte (mezcla todo)");

        // Punto crítico:
        // En vez de un Proxy-portero, el mismo "reporte" revisa permisos.
        // Eso lo vuelve difícil de mantener y fácil de dañar.

        // Simulación: “reporte” con seguridad dentro (mal diseño)
        if (!user.canViewReport) {                 // <-- si alguien quita esta línea...
            System.out.println("Acceso denegado"); //     ...se rompe la seguridad.
            return;
        }

        new SensitiveFinancialData().showReport();
        System.out.println("LOG: acceso de " + user.name);

        // ¿Por qué se rompe si quitan partes?
        // Porque si quitas el if de arriba, SIEMPRE muestra el reporte.
    }
}
