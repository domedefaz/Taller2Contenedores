package ec.edu.uce.pa.paquete;
 
import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
 
//Ambitos y contexos
//ApplicationScoped  //su ambito es durante toda la aplicaacion, se crea una sola instancia de la clase y se comparte entre todos los componenetes que la utiliusan
//@RequestScoped  // su ambito es en apliccaciones WEB durante el recuest-peticion HTTP es decir se crea u
//@SessionScoped  // su ambito es en una palicacion  web durante la secion del usuario
//@Singleton //su ambito es durante toda la aplicaacion, se crea una sola instancia de la clase y se comparte entre todos los componenetes que la utiliusan
@Dependent // sua mbito es durante la inyeccion de dependenciaas es decir se crea se crea una sola instancia de la clase y se comparte entre todos los componenetes que la utiliuzan durante la inyeccion de dependencias
@Named("mail")
public class MailService implements Notificacion {
 
    private Integer cantidad = 0;
    private String nombre;
 
   
 
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviar correo a " + destino);
        System.out.println("Mensaje " + mensaje);
        System.out.println("Correo enviado con exito");
        System.out.println("Fin del envio del correo");
        //cantidad++;
 
    }
 
    public Integer getCantidad() {
        return cantidad;
    }
 
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}