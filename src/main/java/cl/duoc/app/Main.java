package cl.duoc.app;

import cl.duoc.gui.VentanaPrincipal;
import cl.duoc.models.*;
import cl.duoc.service.EstadoPedido;
import cl.duoc.service.ZonaDeCarga;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        Pedido pedido1 = new Pedido(1,  "Ez. Taquearde 2035", "Comida", EstadoPedido.PENDIENTE);
        Pedido pedido2 = new Pedido(2, "Grecia 4562",  "Encomienda",  EstadoPedido.PENDIENTE);
        Pedido pedido3 = new Pedido(3,  "Saturno 06", "Comida", EstadoPedido.PENDIENTE);
        Pedido pedido4 = new Pedido(4,  "El Sastre 20",  "Encomienda",  EstadoPedido.PENDIENTE);
        Pedido pedido5 = new Pedido(5, "El Vertedero 666", "Express", EstadoPedido.PENDIENTE);

        System.out.println("\n.....:::Pedidos SPEEDFAST:::.....");

        zonaDeCarga.agregarPedido(pedido1);
        zonaDeCarga.agregarPedido(pedido2);
        zonaDeCarga.agregarPedido(pedido3);
        zonaDeCarga.agregarPedido(pedido4);
        zonaDeCarga.agregarPedido(pedido5);

        System.out.println("\nPedidos han llegado a la zona de carga.");

        SwingUtilities.invokeLater(() ->{
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(zonaDeCarga);
            ventanaPrincipal.setVisible(true);
        });
    }
}