package ec.edu.uce.pa.matricula;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private MatriculaService matriculaService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("--- INICIANDO SISTEMA DE MATRICULAS QUARKUS ---");

        // Creamos el objeto manualmente como vimos en clase
        Estudiante estudiante = new Estudiante(
            "1728394050", 
            "Domenica Defaz", 
            "Ingeniería en Computación", 
            "0991234567"
        );

        // Invocamos el servicio matriculador
        this.matriculaService.matricular(estudiante);

        return 0;
    }
}
