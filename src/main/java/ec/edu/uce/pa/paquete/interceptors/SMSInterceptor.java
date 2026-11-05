package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@SMS
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 30) 
public class SMSInterceptor {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        Object resul = context.proceed();
        System.out.println("[Interceptor SMS] Notificación enviada por SMS");
        return resul;
    }
}