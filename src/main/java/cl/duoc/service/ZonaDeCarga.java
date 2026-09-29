package cl.duoc.service;

import cl.duoc.models.Pedido;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ZonaDeCarga {

    private final LinkedBlockingQueue<Pedido> colaPedidos;
    private final ReentrantLock lock;

    public ZonaDeCarga(){
        colaPedidos = new LinkedBlockingQueue<>();
        lock = new ReentrantLock();
    }
    public synchronized void agregarPedido (Pedido p){
        lock.lock();

        try{
            colaPedidos.add(p);
            System.out.println("Pedido " + p.getIdPedido() + " agregado a la cola...");
        }finally{
            lock.unlock();
        }
    }

    public Pedido retirarPedido(){
        lock.lock();
        try{
            return colaPedidos.poll();
        }finally{
            lock.unlock();
        }
    }

    public int cantidadPedidos(){
        return colaPedidos.size();
    }

    public synchronized ArrayList<Pedido> listaPedidos(){
        lock.lock();

        try{
            return new ArrayList<>(colaPedidos);
            }finally{
            lock.unlock();
        }
    }
}