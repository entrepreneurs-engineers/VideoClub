
package com.co.videoclub.persistencia.dao;

import com.co.videoclub.exception.BDException;
import java.util.List;
import com.co.videoclub.persistencia.config.Conexion;
import com.co.videoclub.persistencia.dto.Alquiler;
import com.co.videoclub.persistencia.dto.Categoria;
import com.co.videoclub.persistencia.dto.Pelicula;

/**
 *
 * @author davigofr
 */
public interface PeliculaDAO {
    public List<Pelicula> obtenerPeliculas() throws BDException;
    public void agregarPelicula(Pelicula pelicula) throws BDException;
    public Pelicula obtenerPelicula(int id) throws BDException;
    public void actualizarPelicula(Pelicula pelicula) throws BDException;
    public List<Categoria> obtenerCategorias() throws BDException;
    public List<Alquiler> obtenerEstado() throws BDException;
    public void setConexionDB(Conexion conexionDB);
}
