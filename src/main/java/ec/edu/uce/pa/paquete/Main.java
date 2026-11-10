package ec.edu.uce.pa.paquete;
 
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionMail;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionSMS;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionWhatsApp;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
 
@QuarkusMain
public class Main implements QuarkusApplication {
 
    @Inject
    private CompraService compraService;
 
    @Inject
    private NotificacionExtensionMail notificacionExtensionMail;
 
    @Inject
    private NotificacionExtensionSMS notificacionExtensionSMS;

    @Inject
    private NotificacionExtensionWhatsApp notificacionExtensionWhatsApp;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
 
    }
 
    @Override
    public int run(String... args) {
        System.out.println("Iniciando la aplicacion Quarkus...");
        Compra compra = new Compra("Domenica", "Laptop", 1250, "dome.defaz@gmail.com", "1215454545");
        compraService.realizar(compra, this.notificacionExtensionMail);
 
        Compra compra1 = new Compra("Domenica", "Laptop", 1250, "dome.defaz@gmail.com", "1215454545");
        compraService.realizar(compra1, this.notificacionExtensionSMS);
        
        Compra compra2 = new Compra("Domenica", "Laptop", 1250, "dome.defaz@gmail.com", "1215454545");
        compraService.realizar(compra2, this.notificacionExtensionWhatsApp);
        

        return 0;
 
    }
 
}