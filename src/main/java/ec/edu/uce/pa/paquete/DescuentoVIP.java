package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("vip")
public class DescuentoVIP implements CalculadoraDescuento {

    public DescuentoVIP() {
        System.out.println("Instancia de Descuento VIP");
    }

    @Override
    public double calcular(double monto) {
        return monto * 0.15; // 15% de descuento
    }
}