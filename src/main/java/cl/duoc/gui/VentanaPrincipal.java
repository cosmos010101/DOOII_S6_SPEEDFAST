package cl.duoc.gui;

import cl.duoc.models.Repartidor;

import cl.duoc.service.ZonaDeCarga;
import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VentanaPrincipal extends JFrame {

    private JButton btnRegistrarPedido;
    private JButton btnListarPedidos;
    private JButton btnAsignarRepartidor;
    private JButton btnIniciarEntrega;
    private ZonaDeCarga zonaDeCarga;

    public VentanaPrincipal(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
        setTitle("SpeedFast");
        setSize(320, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        crearComponentes(zonaDeCarga);
    }

    private void crearComponentes(ZonaDeCarga zonaDeCarga) {

        setLayout(null);

        btnRegistrarPedido = new JButton("Registrar Pedido");
        btnListarPedidos = new JButton("Listar Pedidos");
        btnAsignarRepartidor = new JButton("Asignar Repartidor");

        btnRegistrarPedido.setBounds(10, 10, 150, 100);
        btnListarPedidos.setBounds(160, 10, 150, 100);
        btnAsignarRepartidor.setBounds(10, 110, 300, 100);

        add(btnRegistrarPedido);
        add(btnListarPedidos);
        add(btnAsignarRepartidor);

        btnRegistrarPedido.addActionListener(e -> {
            try {
                RegistrarPedido();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnListarPedidos.addActionListener(e -> ListarPedidos());
        btnAsignarRepartidor.addActionListener(e -> AsignarRepartidor());
    }

    private void RegistrarPedido() {
        SwingUtilities.invokeLater(() -> {
            VentanaRegistroPedido ventanaRegistroPedido = new VentanaRegistroPedido(zonaDeCarga);
            ventanaRegistroPedido.setVisible(true);
        });
    }

    private void ListarPedidos() {
        SwingUtilities.invokeLater(() -> {
            VentanaListaPedidos ventanaListaPedidos = new VentanaListaPedidos(zonaDeCarga);
            ventanaListaPedidos.setVisible(true);
        });
    }

    private void AsignarRepartidor() {

        Repartidor repartidor1 = new Repartidor("Luz Celeste", zonaDeCarga);
        Repartidor repartidor2 = new Repartidor("Deborah Cabezas", zonaDeCarga);
        Repartidor repartidor3 = new Repartidor("Armando Mocha", zonaDeCarga);


        ExecutorService ejecutor = Executors.newFixedThreadPool(3);
        ejecutor.execute(repartidor1);
        ejecutor.execute(repartidor2);
        ejecutor.execute(repartidor3);

        ejecutor.shutdown();

    }
}

/* Thread t1 = new Thread(repartidor1);
        Thread t2 = new Thread(repartidor2);
        Thread t3 = new Thread(repartidor3);
*/