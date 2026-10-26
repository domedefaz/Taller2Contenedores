package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private VentaService ventaService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("***** SIMULADOR DE DESCUENTOS QUARKUS *****");

        // 4 ventas predefinidas según la tabla del taller[cite: 1]
        ventaService.procesarVenta("REGULAR", 100.00);
        ventaService.procesarVenta("VIP", 200.00);
        ventaService.procesarVenta("REGULAR", 300.00);
        ventaService.procesarVenta("VIP", 500.00);

        System.out.println("***** FIN DE LA EJECUCION *****");
        return 0;
    }
}