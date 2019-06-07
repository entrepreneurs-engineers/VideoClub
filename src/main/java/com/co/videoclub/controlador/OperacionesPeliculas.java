package com.co.videoclub.controlador;

import com.co.videoclub.businesslogic.PeliculasBusiness;
import com.co.videoclub.exception.BDException;
import com.co.videoclub.exception.BusinessException;
import java.util.List;
import com.co.videoclub.persistencia.dto.Categoria;
import com.co.videoclub.persistencia.dto.Pelicula;
import java.util.Date;

/**
 *
 * @author davigofr
 */
public interface OperacionesPeliculas {
    public List<Pelicula> obtenerAllPeliculas() throws BDException;
    public List<Categoria> obtenerAllCategorias() throws BDException;
    public void guardarNuevaPelicula(String nombre, Date anio, int duracion,
            String descripcion, Categoria categoria) throws BDException, BusinessException;
    public Pelicula getPeliculaById(int id) throws BDException;
    public void actualizarPelicula(int id, String nombre, Date anio, int duracion,
            String descripcion, Categoria categoria) throws BDException;
    public void setPeliculaBusiness(PeliculasBusiness peliculaNegocio);
    public int obtenerIdCategoria(String categoria) throws BDException;
}
