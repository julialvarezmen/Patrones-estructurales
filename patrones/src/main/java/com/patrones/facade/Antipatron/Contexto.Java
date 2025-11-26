package com.patrones.facade;

import com.patrones.estructurales.facade.sistemas.complejos.InventorySystem;
import com.patrones.estructurales.facade.sistemas.complejos.PaymentSystem;
import com.patrones.estructurales.facade.sistemas.complejos.ShippingSystem;

public class Contexto {
    public static void main(String[] args) {

        InventorySystem inventorySystem = new InventorySystem();
        PaymentSystem paymentSystem = new PaymentSystem();
        ShippingSystem shippingSystem = new ShippingSystem();

        String productId = "12345";
        int quantity = 1;
        String cardDetails = "4000 1234 5678 9010";
        double amount = 100.00;
        String address = "Calle 123";

        // 1) Verificar stock
        if (!inventorySystem.checkStock(productId, quantity)) {
            System.out.println("Producto no disponible en la cantidad solicitada.");
            System.out.println("No se pudo completar la orden.");
            return;
        }

        // 2) Procesar pago
        if (!paymentSystem.processPayment(cardDetails, amount)) {
            System.out.println("El pago no ha sido aprobado.");
            System.out.println("No se pudo completar la orden.");
            return;
        }

        // 3) Programar envío
        shippingSystem.scheduleDelivery(address, productId);

        System.out.println("Orden realizada con éxito.");
    }
}
