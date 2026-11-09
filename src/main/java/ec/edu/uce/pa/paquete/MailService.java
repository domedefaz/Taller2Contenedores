package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.Reservacion;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MailService {

    public void enviarCorreo(Reservacion reservacion) {

        System.out.println("Enviando correo a: " + reservacion.getCorreo());

        System.out.println("Correo: Confirmacion de reservacion " + "enviada correctamente.");
    }
}
