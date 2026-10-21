package ec.edu.uce.pa.matricula;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class MatriculaService {

    @Inject // Inyección de dependencia gestionada por el contenedor ArC
    private NotificacionService notificacionService;

    public void matricular(Estudiante estudiante) {
        System.out.println("Procesando matrícula...");
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Cédula: " + estudiante.getCedula());
        System.out.println("Carrera: " + estudiante.getCarrera());
        System.out.println("Matrícula registrada correctamente en el sistema.");

        String mensaje = "Estimado/a " + estudiante.getNombre() + 
                         ", su matrícula para la carrera de " + estudiante.getCarrera() + 
                         " ha sido exitosa.";
        
        // Usamos el servicio inyectado
        this.notificacionService.enviarSms(estudiante.getTelefono(), mensaje);
    }
}
