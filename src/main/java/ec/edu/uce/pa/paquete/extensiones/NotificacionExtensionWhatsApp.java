package ec.edu.uce.pa.paquete.extensiones;
 
import jakarta.enterprise.context.ApplicationScoped;
 
@ApplicationScoped
public class NotificacionExtensionWhatsApp implements NotificacionExtension {
 
    @Override
    public void enviar(String mensaje, String destiantario) {
        System.out.println("Enviando WhatsApp a: " + destiantario);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("WhatsApp enviado con exito.");
 
    }
 
}