package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private PedidoService pedidoService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando la aplicacion Quarkus...");

        Pedido pedido = new Pedido("Domenica", "Laptop", 1250, "dome.defaz@gmail.com");// crear manualmente el objeto de la
        pedido.setTelefono("1215454545"); // // clase Pedido
        this.pedidoService.realizar(pedido, "");

        return 0;

    }

}