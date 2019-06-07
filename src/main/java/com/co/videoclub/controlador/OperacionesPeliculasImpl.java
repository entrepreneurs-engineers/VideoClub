
package com.co.videoclub.controlador;

import com.co.videoclub.businesslogic.PeliculasBusiness;
import com.co.videoclub.businesslogic.PeliculasBusinessImpl;
import com.co.videoclub.exception.BDException;
import com.co.videoclub.exception.BusinessException;
import java.util.List;
import com.co.videoclub.persistencia.dto.Categoria;
import com.co.videoclub.persistencia.dto.Pelicula;
import java.util.Date;

/**
 * Controlador encargado de conectarse entre la vista
 * y la capa de negocio para las operaciones de las peliculas
 * @author davigofr
 */
public class OperacionesPeliculasImpl implements OperacionesPeliculas{
    
    private PeliculasBusiness peliculaBusiness;

    public OperacionesPeliculasImpl() {
    }
    
    /**
     * Devuelve todas las peliculas
     * @return
     * @throws BDException
     */
    @Override
    public List<Pelicula> obtenerAllPeliculas() throws BDException{
        List<Pelicula> peliculas = this.getPeliculaBusiness().obtenerAllPeliculas();
        return peliculas;
    }
    
    /**
     * Devuelve todas las categorias
     * @return
     * @throws BDException
     */
    @Override
    public List<Categoria> obtenerAllCategorias() throws BDException{
        List<Categoria> categorias = this.getPeliculaBusiness().obtenerAllCategorias();
        return categorias;
    }
    
    /**
     * Guarda una nueva pelicula con su respectiva informacion
     * @param nombre
     * @param anio
     * @param duracion
     * @param descripcion
     * @param categoria
     * @throws BDException
     */
    @Override
    public void guardarNuevaPelicula(String nombre, Date anio, int duracion,
            String descripcion, Categoria categoria) throws BDException, BusinessException{
        Pelicula pelicula = new Pelicula();
        pelicula.setNombre(nombre);
        pelicula.setAño(anio);
        pelicula.setDuracion(duracion);
        pelicula.setDescripcion(descripcion);
        pelicula.setCategoria(categoria);
        
        this.getPeliculaBusiness().guardarNuevaPelicula(pelicula);
    }
    
    /**
     * Devuelve una pelicula filtrada por el id
     * @param id de la pelicula
     * @return Informacion de la pelicula
     * @throws BDException
     */
    @Override
    public Pelicula getPeliculaById(int id) throws BDException{
        Pelicula peliBuscada = this.getPeliculaBusiness().getPeliculaById(id);
        
        if(peliBuscada == null){
            throw new BDException("No existe la pelicula");
        }
        
        return peliBuscada;
    }
    
    /**
     * Actualiza la pelicula
     * @param id
     * @param nombre
     * @param anio
     * @param duracion
     * @param descripcion
     * @param categoria
     * @throws BDException
     */
    @Override
    public void actualizarPelicula(int id, String nombre, Date anio, int duracion,
            String descripcion, Categoria categoria) throws BDException{
        // Busco la pelicula para ver que si exista antes de actualizar
        this.getPeliculaById(id);
        
        Pelicula pelicula = new Pelicula();
        pelicula.setId(id);
        pelicula.setNombre(nombre);
        pelicula.setAño(anio);
        pelicula.setDuracion(duracion);
        pelicula.setDescripcion(descripcion);
        pelicula.setCategoria(categoria);
        
        this.getPeliculaBusiness().actualizarPelicula(pelicula);
    }

    private PeliculasBusiness getPeliculaBusiness() {
        if(peliculaBusiness == null){
            peliculaBusiness = new PeliculasBusinessImpl();
        }
        return peliculaBusiness;
    }

    /**
     * Objeto que persiste la informacion
     * @param peliculaBusiness
     */
    @Override
    public void setPeliculaBusiness(PeliculasBusiness peliculaBusiness) {
        this.peliculaBusiness = peliculaBusiness;
    }
    
    /**
     * Obtiene el id de la categoria de acuerdo a su descripcion
     * @param categoria Nombre de la categoria
     * @return id de la categoria
     * @throws BDException
     */
    @Override
    public int obtenerIdCategoria(String categoria) throws BDException{
        int id = 0;
        List<Categoria> categorias = obtenerAllCategorias();
        for (Categoria categoriaP : categorias) {
            if(categoria.equals(categoriaP.getNombre())){
                id = categoriaP.getId();
                break;
            }
        }
        return id;
    }
}
