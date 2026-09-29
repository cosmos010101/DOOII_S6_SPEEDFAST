package cl.duoc.models;

import cl.duoc.service.EstadoPedido;
import cl.duoc.service.ZonaDeCarga;

import static cl.duoc.service.EstadoPedido.EN_REPARTO;


public class Repartidor implements Runnable{

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() { //hacer que esto se vea en la interfaz

        Pedido p;

        while (zonaDeCarga.cantidadPedidos() > 0){
      //  while (zonaDeCarga.cantidadPedidos() > 0){
            p = zonaDeCarga.retirarPedido();

            if (p != null){
                System.out.println("\n -> Entregando pedido " + p.getIdPedido() + " al repartidor: " + nombre + ".");
                System.out.println(p);
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    System.out.println("Repartidor no encontrado.");
                }
                System.out.println("\n --> Pedido: " + p.getIdPedido() + " retirado por el repartidor: " + nombre  + ".");
                p.setEstado(EN_REPARTO);

                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    System.out.println("Repartidor se ha dado a la fuga con tu pedido.... D:");
                }
                System.out.println("\n ---> Pedido: " + p.getIdPedido() + " entregado correctamente por: " + nombre + ".");
                p.setEstado(EstadoPedido.ENTREGADO);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("\n|El repartidor " + nombre + " finalizo su entrega.|");
        }
    }
}