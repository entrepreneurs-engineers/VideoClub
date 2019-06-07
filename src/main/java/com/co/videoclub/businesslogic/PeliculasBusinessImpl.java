
package com.co.videoclub.businesslogic;

import com.co.videoclub.businesslogic.validaciones.PeliculaBusinessValidation;
import com.co.videoclub.businesslogic.validaciones.PeliculaBusinessValidationImpl;
import com.co.videoclub.exception.BDException;
import com.co.videoclub.exception.BusinessException;
import java.util.List;
import com.co.videoclub.persistencia.dao.PeliculaDAO;
import com.co.videoclub.persistencia.dao.PeliculaDAOImpl;
import com.co.videoclub.persistencia.dto.Categoria;
import com.co.videoclub.persistencia.dto.Pelicula;

/**
 *
 * @author davigofr
 */
public class PeliculasBusinessImpl implements PeliculasBusiness{
    
    private PeliculaBusinessValidation peliculasValidaciones;
    private PeliculaDAO peliculaServicio;

    @Override
    public List<Pelicula> obtenerAllPeliculas() throws BDException {
        return this.getPeliculaServicio().obtenerPeliculas();
    }

    @Override
    public List<Categoria> obtenerAllCategorias() throws BDException {
        return this.getPeliculaServicio().obtenerCategorias();
    }

    @Override
    public void guardarNuevaPelicula(Pelicula pelicula) throws BDException, BusinessException {
        String validador = this.getPeliculaValidaciones().
                validarCamposObligatorios(pelicula);
        if(validador.isEmpty()){
            this.getPeliculaServicio().agregarPelicula(pelicula);
        }else{
            throw new BusinessException("Error de validacion, mensaje: " + validador);
        }
    }

    @Override
    public Pelicula getPeliculaById(int id) throws BDException {
        return this.getPeliculaServicio().obtenerPelicula(id);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) throws BDException {
        this.getPeliculaServicio().actualizarPelicula(pelicula);
    }

    @Override
    public void setPeliculaServicio(PeliculaDAO peliculaServicio) {
        this.peliculaServicio = peliculaServicio;
    }
    
    private PeliculaBusinessValidation getPeliculaValidaciones(){
        if(peliculasValidaciones == null){
            peliculasValidaciones = new PeliculaBusinessValidationImpl();
        }
        return peliculasValidaciones;
    }
    
    private PeliculaDAO getPeliculaServicio(){
        if(peliculaServicio == null){
            peliculaServicio = new PeliculaDAOImpl();
        }
        return peliculaServicio;
    }
}
