package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Auditoria {

    public Auditoria() {
        System.out.println("Instancia de Auditoria (Dependent)");
    }

    public void registrar(String tipo, double monto, String porcentaje, double descuentoDolares, double total) {
        System.out.println("--- AUDITORIA DE VENTA ---");
        System.out.println("Tipo Cliente: " + tipo + " | Monto: $" + monto + " | Descuento: " + porcentaje + " ($" + descuentoDolares + ") | Total Final: $" + total);
        System.out.println("--------------------------");
    }
}