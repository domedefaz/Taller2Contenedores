package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Mail
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 40)
public class MailInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("[Interceptor Mail] INICIO mail");
        Object resul = context.proceed();
        OrdenEjecucion.agregar("[Interceptor mail] FIN Mail");
        return resul;
    }
}