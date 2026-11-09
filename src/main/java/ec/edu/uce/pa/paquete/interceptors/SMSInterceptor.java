package ec.edu.uce.pa.paquete.interceptors;

import ec.edu.uce.pa.paquete.Reservacion;
import ec.edu.uce.pa.paquete.SMSService;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Sms 
@Interceptor
@jakarta.annotation.Priority(Interceptor.Priority.APPLICATION + 30)
public class SMSInterceptor {

    @Inject
    SMSService smsService;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        System.out.println("[Interceptor SMS] INICIO SMS");

        Object resultado = context.proceed();

        Reservacion reservacion = (Reservacion) context.getParameters()[0];

        smsService.enviarSMS(reservacion);

        OrdenEjecucion.agregar("[Interceptor SMS] FIN SMS");

        return resultado;
    }
}