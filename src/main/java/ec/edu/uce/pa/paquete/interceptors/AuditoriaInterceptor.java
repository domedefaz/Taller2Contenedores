package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Reservacion;
import ec.edu.uce.pa.paquete.AuditoriaService;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria
@Interceptor
@jakarta.annotation.Priority(Interceptor.Priority.APPLICATION + 20)
public class AuditoriaInterceptor {

    @Inject
    AuditoriaService auditoriaService;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        System.out.println("[Auditoria] INICIO auditoria");

        Object resultado = context.proceed();

        System.out.println("[Auditoria] Se esta ejecutando el metodo: " + context.getMethod().getName());

        System.out.println("Ejecuto todo lo que quiero que haga " + "el interceptor");

        for (var parametro : context.getParameters()) {
            System.out.println("Parametro: " + parametro.getClass().getSimpleName());
        }

        Reservacion reservacion = (Reservacion) context.getParameters()[0];

        auditoriaService.guardarEnLaBase(reservacion);

        OrdenEjecucion.agregar("[Auditoria] FIN auditoria");

        return resultado;
    }
}
