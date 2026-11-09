package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 10)
public class MedirTiempoInter {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        Long init = System.currentTimeMillis();

        OrdenEjecucion.limpiar();
        System.out.println("[MedirTiempo] INICIO medir tiempo...");

        Object resultado = context.proceed();

        Long fin = System.currentTimeMillis();

        OrdenEjecucion.agregar("[Interceptor] El metodo demoro: " + (fin - init) + " ms");
        OrdenEjecucion.agregar("[MedirTiempo] FIN medir tiempo");
        OrdenEjecucion.mostrar();

        return resultado;
    }
}
