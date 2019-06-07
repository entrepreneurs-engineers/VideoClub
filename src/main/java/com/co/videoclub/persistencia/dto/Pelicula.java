package com.co.videoclub.persistencia.dto;

import java.util.Date;

/**
 *
 * @author davigofr
 */
public class Pelicula {
    private int id;
    private String nombre;
    private int duracion;
    private String descripcion;
    private Date año;
    private Categoria categoria;

    public Pelicula() {
    }
    
    public Pelicula(int id, String nombre, int duracion, String descripcion, Date año, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.año = año;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getAño() {
        return año;
    }

    public void setAño(Date año) {
        this.año = año;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", descripcion=" + descripcion + ", a\u00f1o=" + año + ", categoria=" + categoria + '}';
    }
}
