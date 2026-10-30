package ec.edu.uce.pa.paquete.interceptors;

import java.lang.reflect.Parameter;

import ec.edu.uce.pa.paquete.AuditoriaService;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditoria 
@Interceptor 
public class AuditoriaInterceptor {

    @Inject 
    private AuditoriaService auditoriaService;

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {

        Object resultado = context.proceed(); // Ejecuta el método interceptado

        System.out.println("Retorno: " + resultado);

        String nombreMetodo = context.getMethod().getName();
        System.out.println("Auditoria: Se esta ejecutando el metodo: " + nombreMetodo);
        System.out.println("Ejecuto todo lo que quiero que haga el interceptor");

        // Reflexión para obtener los parámetros del método
        Parameter[] parametros = context.getMethod().getParameters();
        for (Parameter parametro : parametros) {
            System.out.println("Parametro: " + parametro.getName());
        }

        // Obtener los valores reales enviados al método procesarVenta (tipo y monto)
        Object[] valores = context.getParameters();
        if (valores != null && valores.length >= 2) {
            String tipo = (String) valores[0];
            double monto = (double) valores[1];

            // Cálculos para la auditoría
            double descuento = "VIP".equalsIgnoreCase(tipo) ? monto * 0.15 : monto * 0.05;
            String porcentajeStr = "VIP".equalsIgnoreCase(tipo) ? "15 %" : "5 %";
            double totalFinal = monto - descuento;

            this.auditoriaService.guardarEnLaBase(tipo, monto, porcentajeStr, descuento, totalFinal);
        }
       
        System.out.println("Mensaje luego de que se ejecuta el metodo interceptado");
        return resultado;
    }
}