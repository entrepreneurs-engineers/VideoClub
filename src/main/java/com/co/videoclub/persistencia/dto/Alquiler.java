
package com.co.videoclub.persistencia.dto;

import java.util.Date;

/**
 *
 * @author davigofr
 */
public class Alquiler {
    private int id;
    private Date fechaAlquiler;
    private Date fechaDevolucion;
    private Cliente cliente;
    private Inventario inventario;

    public Alquiler() {
    }

    public Alquiler(int id, Date fechaAlquiler, Date fechaDevolucion, Cliente cliente, Inventario inventario) {
        this.id = id;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
        this.cliente = cliente;
        this.inventario = inventario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "id=" + id + ", fechaAlquiler=" + fechaAlquiler + ", fechaDevolucion=" + fechaDevolucion + ", cliente=" + cliente + ", inventario=" + inventario + '}';
    }
}
