package ec.edu.uce.pa.matricula;

public class Estudiante {

    private String cedula;
    private String nombre;
    private String carrera;
    private String telefono;

    // Constructor
    public Estudiante(String cedula, String nombre, String carrera, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}