
package ec.edu.uce.pa.paquete;

public class Reservacion {

    // datos de una persona que reserva una habitación en nuestro hotel.

    private String cliente;
    private String tipoHabitacion;
    private int numeroHabitacion;
    private int noches;
    private double precioPorNoche;
    private String correo;
    private String telefono;

    // Constructor
    public Reservacion(String cliente, String tipoHabitacion,int numeroHabitacion, int noches, double precioPorNoche,
            String correo, String telefono) {

        this.cliente = cliente;
        this.tipoHabitacion = tipoHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.noches = noches;
        this.precioPorNoche = precioPorNoche;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Metodo para calcular el total de la reservacion
    public double getTotal() {
        return noches * precioPorNoche;
    }

    // Metodos Getters
    public String getCliente() {
        return cliente;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public int getNoches() {
        return noches;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }
}
