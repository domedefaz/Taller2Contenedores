package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Reservacion;
import ec.edu.uce.pa.paquete.MailService;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Mail
@Interceptor
@jakarta.annotation.Priority(Interceptor.Priority.APPLICATION + 40)
public class MailInterceptor {

    @Inject
    MailService mailService;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        System.out.println("[Interceptor Mail] INICIO Mail");

        Object resultado = context.proceed();

        Reservacion reservacion = (Reservacion) context.getParameters()[0];

        mailService.enviarCorreo(reservacion);

        OrdenEjecucion.agregar("[Interceptor Mail] FIN Mail");

        return resultado;
    }
}
