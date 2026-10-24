package ec.edu.uce.pa.paquete;
 
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
 
@QuarkusMain
public class Main implements QuarkusApplication {
 
    @Inject
    private PedidoService pedidoService;
    @Inject
    private CompraService compraService;
 
    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
 
    }
 
    @Override
    public int run(String... args) {
        System.out.println("Iniciando la aplicacion Quarkus...");
 
        Pedido pedido = new Pedido("Juan Perez", "Laptop", 1250, "juan@gmail.com");// crear manualmente el objeto de la
        pedido.setTelefono("1215454545"); // // clase Pedido
        this.pedidoService.realizar(pedido);
 
        Compra compra=new Compra("Domenica", "Laptop", 5400.00, "dome.defaz@gmail.com", "09540552003");
        compraService.realizar(compra);
 
 
        return 0;
 
    }
 
}