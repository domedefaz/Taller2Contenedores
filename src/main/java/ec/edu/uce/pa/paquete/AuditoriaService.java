package ec.edu.uce.pa.paquete;

import java.time.LocalDateTime;
import jakarta.inject.Singleton;

@Singleton 
public class AuditoriaService {

    public void guardarEnLaBase(String tipo, double monto, String porcentaje, double descuentoDolares, double total) {
        System.out.println("Guardando en la base de datos la auditoría: Tipo: " + tipo + ", Monto: " + monto + ", Descuento: " + porcentaje + " ($" + descuentoDolares + "), Total Final: " + total);
        System.out.println("Fecha y hora: " + LocalDateTime.now());
    }
}