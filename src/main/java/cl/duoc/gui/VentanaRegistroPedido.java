package cl.duoc.gui;

import cl.duoc.models.Pedido;
import cl.duoc.service.EstadoPedido;
import cl.duoc.service.ZonaDeCarga;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaRegistroPedido extends JFrame {

    private JTextField txtIDPedido;
    private JTextField txtDireccion;
    private JComboBox txtTipo;
    private ZonaDeCarga zonaDeCarga;

    public VentanaRegistroPedido(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
        setTitle("Registrar Pedido");
        setSize(330, 250);
        setLocationRelativeTo(null);
        crearComponentes();
    }

    private void crearComponentes() {

        setLayout(null);

        JLabel lblIDPedido = new JLabel("ID de Pedido");
        JLabel lblDireccion = new JLabel("Dirección");
        JLabel lblTipo = new JLabel("Tipo de Pedido");
        txtIDPedido = new JTextField();
        txtDireccion = new JTextField();
        txtTipo = new JComboBox<>(new String[]{
                "Comida", "Encomienda", "Express"
        });
        JButton btnGuardar = new JButton("Guardar");

        lblIDPedido.setBounds(10, 10, 100, 20);
        lblDireccion.setBounds(10, 40, 100, 20);
        lblTipo.setBounds(10, 70, 100, 20);
        txtIDPedido.setBounds(120, 10, 100, 20);
        txtDireccion.setBounds(120, 40, 100, 20);
        txtTipo.setBounds(120, 70, 100, 20);
        btnGuardar.setBounds(60, 100, 110, 40);

        add(lblIDPedido);
        add(lblDireccion);
        add(lblTipo);
        add(txtIDPedido);
        add(txtDireccion);
        add(txtTipo);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> Guardar());

    }

    private void Guardar() {
//id, direccion, tipo, estado.pendiente

        try{
            Pedido pedido = new Pedido(Integer.parseInt(txtIDPedido.getText()), txtDireccion.getText(), txtTipo.getSelectedItem().toString(), EstadoPedido.PENDIENTE);
            zonaDeCarga.agregarPedido(pedido);
            JOptionPane.showMessageDialog(null, "Se ha registrado el pedido");
            txtIDPedido.setText("");
            txtDireccion.setText("");
            txtTipo.setSelectedIndex(0);
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero entero de ID");
        }

    }
    }
/*

        //pedidos.add(new Controlador(Integer.parseInt(txtIDPedido.getText()), txtDireccion.getText(), txtTipo.getSelectedItem().toString(), EstadoPedido.PENDIENTE));

        if(txtIDPedido.getText().isEmpty() || txtDireccion.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe completar los campos en vacíos.");
            return;
        }else {
            try {
                int id = Integer.parseInt(txtIDPedido.getText());
                String direccion = txtDireccion.getText();
                String tipo = txtTipo.getSelectedItem().toString();
                Controlador pedido1 = new Controlador(txtIDPedido.getText(), txtDireccion.getText(), txtTipo.getSelectedItem().toString(), EstadoPedido.PENDIENTE);
                ZonaDeCarga.agregarPedido(pedidos);
                JOptionPane.showMessageDialog(null, "Se ha registrado el pedido");
                txtIDPedido.setText("");
                txtDireccion.setText("");
                txtTipo.setSelectedIndex(0);

                pedidos.add(pedido1);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero entero de ID");
            }
        }
    }
}
    /*
    •	Clase VentanaRegistroPedido (JFrame) con campos:
o	ID, Dirección, Tipo (JComboBox: comida, encomienda, express)
•	Botón Guardar que:
o	Valide campos
o	Cree y agregue un Pedido a la lista/controlador
o	Muestre confirmación con JOptionPane

     */