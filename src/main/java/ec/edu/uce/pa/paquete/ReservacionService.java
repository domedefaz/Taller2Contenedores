package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.MedirTiempo;
import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import ec.edu.uce.pa.paquete.interceptors.Sms;
import ec.edu.uce.pa.paquete.interceptors.Mail;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ReservacionService {

    @MedirTiempo
    @Auditoria
    @Sms
    @Mail
    public String realizar(Reservacion reservacion, String valor1) {

        Long init = System.currentTimeMillis();

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Realizando reservacion......");
        System.out.println("Reservacion realizada para el cliente: " + reservacion.getCliente());
        System.out.println("Tipo de habitacion: " + reservacion.getTipoHabitacion());
        System.out.println("Numero de habitacion: " + reservacion.getNumeroHabitacion());
        System.out.println("Noches reservadas: " + reservacion.getNoches());
        System.out.println("Precio por noche: " + reservacion.getPrecioPorNoche());
        System.out.println("Total: " + reservacion.getTotal());
        System.out.println("Correo: " + reservacion.getCorreo());
        System.out.println("Telefono: " + reservacion.getTelefono());
        System.out.println("Reservacion realizada con exito");

        Long fin = System.currentTimeMillis() - init;

        return "[ReservacionService] Reservacion realizada con exito" + "\nTiempo de ejecucion: " + fin + " ms";
    }
}
