package ec.edu.uce.pa.paquete;

import java.time.LocalDateTime;

import ec.edu.uce.pa.paquete.Reservacion;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuditoriaService {

    public void guardarEnLaBase(Reservacion reservacion) {

        System.out.println("Guardando en la base de datos la auditoria:");
        System.out.println("Cliente: " + reservacion.getCliente());
        System.out.println("Habitacion: " + reservacion.getNumeroHabitacion());
        System.out.println("Total: " + reservacion.getTotal());
        System.out.println("Correo: " + reservacion.getCorreo());
        System.out.println("Con fecha y hora: " + LocalDateTime.now());
    }
}