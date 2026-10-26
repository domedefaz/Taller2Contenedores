package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class VentaService {

    // Inyección por atributo
    @Inject
    private Auditoria auditoria;

    // Inyección por constructor 
    private final CalculadoraDescuento calculadoraRegular;
    private final CalculadoraDescuento calculadoraVIP;

    @Inject
    public VentaService(@Named("regular") CalculadoraDescuento calculadoraRegular,
            @Named("vip") CalculadoraDescuento calculadoraVIP) {
        System.out.println("Instancia de VentaService");
        this.calculadoraRegular = calculadoraRegular;
        this.calculadoraVIP = calculadoraVIP;
    }

    public void procesarVenta(String tipo, double monto) {
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

        // Registrar en auditoría enviando el porcentaje y el descuento en dinero
        auditoria.registrar(tipo, monto, porcentajeStr, descuento, totalFinal);
    }
}