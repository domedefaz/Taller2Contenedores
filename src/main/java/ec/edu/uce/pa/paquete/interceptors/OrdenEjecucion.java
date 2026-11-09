package ec.edu.uce.pa.paquete.interceptors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenEjecucion {

    private static final ThreadLocal<List<String>> mensajes = ThreadLocal.withInitial(ArrayList::new);

    public static void limpiar() {
        mensajes.get().clear();
    }

    public static void agregar(String mensaje) {
        mensajes.get().add(mensaje);
    }

    public static void mostrar() {

        List<String> lista = mensajes.get();
        Collections.reverse(lista);

        for (String mensaje : lista) {
            System.out.println(mensaje);
        }

        mensajes.remove();
    }
}
