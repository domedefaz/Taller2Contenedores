package ec.edu.uce.pa.paquete;
 
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
 
@ApplicationScoped // delego el control al contenedor ARC
// @RequestScoped // para aplicaciones web
// @Singleton
public class PedidoService {
 
    //inyeccion de dependencias por atributo
     @Inject //
    private MailService mailService;
 
    /*  private MailService mailService;
     
    // inyeccion de dependencias por constructor
     @Inject
     public PedidoService(MailService mailService) {
     this.mailService = mailService;
    
     } */
 
    /*private MailService mailService;
 
    //inyeccion de dependencia por setter
    @Inject
    public void setMailService(MailService mailService) {
        System.out.println("se esta inyectando el servicio de correo electronico pedidoservice");
        this.mailService = mailService;
    }*/
 
    public void realizar(Pedido pedido) {
        System.out.println("Realizando pedido......");
        System.out.println("Pedido realizado para el cliente: " + pedido.getCliente());
        System.out.println("Producto:" + pedido.getProducto());
        System.out.println("Total:" + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con éxito");
 
        String asunto = "Confirmacion pedido";
        String cuerpo = "Estimado" + pedido.getCliente() + " su pedido de " +
                pedido.getProducto() + " por un  total de $" + pedido.getTotal()
                + "ha sido realizado con exito.";
        this.mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
    }
 
}
