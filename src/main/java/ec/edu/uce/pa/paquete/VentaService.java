package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class VentaService {

    private final CalculadoraDescuento calculadoraRegular;
    private final CalculadoraDescuento calculadoraVIP;

    @Inject
    public VentaService(@Named("regular") CalculadoraDescuento calculadoraRegular,
            @Named("vip") CalculadoraDescuento calculadoraVIP) {
        System.out.println("Instancia de VentaService");
        this.calculadoraRegular = calculadoraRegular;
        this.calculadoraVIP = calculadoraVIP;
    }

    @Auditoria
    public String procesarVenta(String tipo, double monto) {
        double descuento = 0;
        String porcentajeStr = "";

        if ("REGULAR".equalsIgnoreCase(tipo)) {
            descuento = calculadoraRegular.calcular(monto);
            porcentajeStr = "5 %";
        } else if ("VIP".equalsIgnoreCase(tipo)) {
            descuento = calculadoraVIP.calcular(monto);
            porcentajeStr = "15 %";
        }

        double totalFinal = monto - descuento;

        System.out.println("------Procesando venta------");
        System.out.println("Tipo Cliente: " + tipo);
        System.out.println("Monto: " + monto);
        System.out.println("Descuento: " + porcentajeStr + " ($" + descuento + ")");
        System.out.println("Total Final: " + totalFinal);
        System.out.println("Venta realizada con éxito...");

        return "Venta realizada con exito...";
    }
}