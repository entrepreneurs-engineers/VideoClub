package com.co.videoclub.businesslogic;

import com.co.videoclub.exception.BDException;
import com.co.videoclub.exception.BusinessException;
import java.util.List;
import com.co.videoclub.persistencia.dao.PeliculaDAO;
import com.co.videoclub.persistencia.dto.Categoria;
import com.co.videoclub.persistencia.dto.Pelicula;

/**
 *
 * Encargada de realizar validaciones de negocio
 * y comunicarse con la capa de persistencia
 * @author davigofr
 */
public interface PeliculasBusiness {
    public List<Pelicula> obtenerAllPeliculas() throws BDException;
    public List<Categoria> obtenerAllCategorias() throws BDException;
    public void guardarNuevaPelicula(Pelicula pelicula) throws BDException, BusinessException;
    public Pelicula getPeliculaById(int id) throws BDException;
    public void actualizarPelicula(Pelicula pelicula) throws BDException;
    public void setPeliculaServicio(PeliculaDAO peliculaServicio);
}
