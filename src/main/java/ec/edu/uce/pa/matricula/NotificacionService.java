package ec.edu.uce.pa.matricula;

import jakarta.inject.Singleton;

@Singleton
public class NotificacionService {

    public void enviarSms(String telefono, String mensaje) {
        System.out.println("Enviando SMS al número: " + telefono);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Notificación enviada con éxito.");
    }
}