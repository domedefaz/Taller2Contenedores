package ec.edu.uce.pa.paquete;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("regular")
public class DescuentoRegular implements CalculadoraDescuento {

    public DescuentoRegular() {
        System.out.println("Instancia de Descuento Regular");
    }

    @Override
    public double calcular(double monto) {
        return monto * 0.05; // 5% de descuento
    }
}