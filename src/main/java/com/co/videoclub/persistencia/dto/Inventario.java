package com.co.videoclub.persistencia.dto;

/**
 *
 * @author davigofr
 */
public class Inventario {
    private int id;
    private int disponible;
    private Pelicula pelicula;

    public Inventario() {
    }

    public Inventario(int id, int disponible, Pelicula pelicula) {
        this.id = id;
        this.disponible = disponible;
        this.pelicula = pelicula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id=" + id + ", disponible=" + disponible + ", pelicula=" + pelicula + '}';
    }
}
