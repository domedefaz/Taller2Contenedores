package ec.edu.uce.pa.paquete;
 
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
 
@ApplicationScoped  //dedlego el control al contenedor ARC
//@RequestScoped  // para aplicaciones web
@Singleton
@Named("mail")
public class MailService implements Notificacion {
 

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Correo enviado con exito.");
        System.out.println("Fin del envio de correo.");
    }
 
}
 