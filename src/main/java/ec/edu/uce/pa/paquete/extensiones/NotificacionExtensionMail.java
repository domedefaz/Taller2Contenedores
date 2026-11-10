package ec.edu.uce.pa.paquete.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class NotificacionExtensionMail implements NotificacionExtension{

    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Enviando Mail a: " + destinatario);
        System.out.println("Mail: " + mensaje);
        System.out.println("Mail enviado con exito.");
    }
}