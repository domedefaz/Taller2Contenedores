package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import jakarta.inject.Inject;

@QuarkusMain
public class MainHotel implements QuarkusApplication {

    @Inject
    ReservacionService reservacionService;

    @Override
    public int run(String... args) throws Exception {

        System.out.println("Iniciando sistema de reservaciones del hotel...");

        Reservacion reservacion = new Reservacion("Domenica", "Suite",
                205, 3, 80.00, "dome.defaz@gmail.com",
                "0999999999");

        String resultado = reservacionService.realizar(
                reservacion, "");

        System.out.println(resultado);

        return 0;
    }

    public static void main(String[] args) {
        Quarkus.run(MainHotel.class, args);
    }
}
