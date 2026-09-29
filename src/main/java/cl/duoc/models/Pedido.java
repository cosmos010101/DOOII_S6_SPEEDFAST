package cl.duoc.models;

import cl.duoc.service.EstadoPedido;

public class Pedido {

    private int idPedido;
    private String direccionEntrega;
    private String tipo;
    private EstadoPedido estadoPedido;

    public Pedido(int idPedido, String direccionEntrega, String tipo, EstadoPedido estadoPedido) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipo = tipo;
        this.estadoPedido = estadoPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getTipo() {
        return tipo;
    }

    public void setEstado(EstadoPedido nuevoEstado) {
        this.estadoPedido = nuevoEstado;
    }

}
