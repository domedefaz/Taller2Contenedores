package ec.edu.uce.pa.paquete;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton 
@Named ("sms")
public class SMSService implements Notificacion{

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando SMS a: " + destino);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("SMS enviado con exito.");
        System.out.println("Fin del envio de SMS.");
    }

    @Override
    public Integer getCantidad() {
        return null;
        

    }

    @Override
    public void setCantidad(Integer cantidad) {
        
        }

    @Override
    public String getNombre() {
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    @Override
    public void setNombre(String nombre) {
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }

}
