package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.Reservacion;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SMSService {

    public void enviarSMS(Reservacion reservacion) {

        System.out.println("Enviando SMS al telefono: " + reservacion.getTelefono());

        System.out.println("SMS: Su reservacion en el hotel " + "ha sido registrada correctamente.");
    }
}
