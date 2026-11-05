package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import ec.edu.uce.pa.paquete.interceptors.MedirTiempo;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PedidoService {

    @MedirTiempo
    @Auditoria
    public String realizar(Pedido pedido, String valor1) {

        Long init = System.currentTimeMillis();
        try {
            Thread.sleep(1500);
        } catch (Exception e) {

        }

        System.out.println("Realizando pedido......");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto:" + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Telefono: " + pedido.getTelefono());
        System.out.println("Pedido realizado con éxito");

        Long fin = System.currentTimeMillis() - init;
        return "[PedidoService] Pedido realizado con exito \nTiempo de ejecucion: " + fin;
    }

}