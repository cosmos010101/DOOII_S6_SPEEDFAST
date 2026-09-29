package cl.duoc.gui;

import cl.duoc.models.Pedido;
import cl.duoc.service.ZonaDeCarga;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VentanaListaPedidos extends JFrame {

    private JTable tabla1;
    private DefaultTableModel tablaModel;
    private JButton btnActualizar;
    private ZonaDeCarga zonaDeCarga;
    private JPanel panel;
    private ArrayList<Pedido> pedidos;

    public VentanaListaPedidos(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
        pedidos = zonaDeCarga.listaPedidos();
        panel = new JPanel();
        tabla1 = new JTable();
        setTitle("Listado de Pedidos");
        setSize(400, 250);
        setLocationRelativeTo(null);

        crearComponentes(zonaDeCarga);
    }
    private void crearComponentes(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
        panel = new JPanel ( new BorderLayout());
        pedidos = zonaDeCarga.listaPedidos();
        tablaModel = new DefaultTableModel(
                new Object[]{"ID", "Dirección", "Tipo Pedido", "Estado"},
                0
        );
        tabla1 = new JTable(tablaModel);
        JScrollPane scrollPane = new JScrollPane(tabla1);
        for (Pedido pedido : pedidos){
            Object[] fila = {
                    pedido.getIdPedido(),
                    pedido.getDireccionEntrega(),
                    pedido.getTipo(),
                    pedido.getEstadoPedido()
            };
            tablaModel.addRow(fila);
        }

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> {actualizar();
        });
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(btnActualizar, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }
    private void actualizar(){
        tablaModel.setRowCount(0);
        for (Pedido pedido : pedidos){
            Object[] fila = {
                    pedido.getIdPedido(),
                    pedido.getDireccionEntrega(),
                    pedido.getTipo(),
                    pedido.getEstadoPedido()
            };
            tablaModel.addRow(fila);
        }
    }
}