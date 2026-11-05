package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority (Interceptor.Priority.APPLICATION + 10)
public class MedirTiempoInter {

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {

        Long init = System.currentTimeMillis();
        Object resul = context.proceed();
        Long fin = System.currentTimeMillis();
        System.out.println("[Interceptor] El metodo demoro: " + (fin - init));
        return resul;
    }

}
