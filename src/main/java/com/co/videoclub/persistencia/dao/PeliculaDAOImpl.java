package com.co.videoclub.persistencia.dao;

import com.co.videoclub.exception.BDException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.co.videoclub.persistencia.config.Conexion;
import com.co.videoclub.persistencia.config.ConexionMySQL;
import com.co.videoclub.persistencia.dto.Alquiler;
import com.co.videoclub.persistencia.dto.Categoria;
import com.co.videoclub.persistencia.dto.Pelicula;
import com.co.videoclub.util.CargarPropiedades;
import com.co.videoclub.util.ConstantesBD;
import com.co.videoclub.util.LoggerApp;
import java.net.URISyntaxException;
import java.sql.Date;

/**
 * Clase que orquesta todas las operaciones de las peliculas (CRUD)
 *
 * @author davigofr
 */
public class PeliculaDAOImpl implements PeliculaDAO {

    private static final CargarPropiedades CARGADOR = CargarPropiedades.getCargarPropiedades();
    private static String verPeliculasSQL;
    private static String obtenerCategoriasSQL;
    private static String insertarPeliculaSQL;
    private static String actualizarPeliculaSQL;
    private static String obtenerPeliculaSQL;
    private Conexion conexionDB;

    static {
        try {
            LoggerApp.info("PeliculaDAOImpl - Cargando archivo de propiedades");
            CARGADOR.cargarPropiedades(ConstantesBD.QUERYS_PROPERTIES);
            verPeliculasSQL = CARGADOR.getPropiedad(ConstantesBD.VER_PELICULAS_SQL);
            obtenerCategoriasSQL = CARGADOR.getPropiedad(ConstantesBD.OBTENER_CATEGORIAS_SQL);
            insertarPeliculaSQL = CARGADOR.getPropiedad(ConstantesBD.INSERTAR_PELICULA);
            actualizarPeliculaSQL = CARGADOR.getPropiedad(ConstantesBD.ACTUALIZAR_PELICULA);
            obtenerPeliculaSQL = CARGADOR.getPropiedad(ConstantesBD.OBTENER_PELICULA);
        } catch (IOException | URISyntaxException ex) {
            LoggerApp.severe("Hubo un error al cargar el archivo de propiedades", ex);
        }
    }

    public PeliculaDAOImpl() {
    }

    private Conexion getConexionDB() {
        if (conexionDB == null) {
            conexionDB = new ConexionMySQL();
        }
        return conexionDB;
    }

    @Override
    public void setConexionDB(Conexion conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public List<Pelicula> obtenerPeliculas() throws BDException {
        LoggerApp.info("PeliculaDAOImpl - Intentando obtener todas las peliculas");
        List<Pelicula> peliculas = new ArrayList<>();
        PreparedStatement preparedStam = null;
        ResultSet rs = null;
        try {
            preparedStam = this.getConexionDB()
                    .getConexion().prepareStatement(verPeliculasSQL);
            rs = preparedStam.executeQuery();

            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("nombreCategoria"));
                pelicula.setId(rs.getInt("idPelicula"));
                pelicula.setNombre(rs.getString("nombrePrelicula"));
                pelicula.setDuracion(rs.getInt("duracionPelicula"));
                pelicula.setDescripcion(rs.getString("descripcionPelicula"));
                pelicula.setAño(rs.getDate("añoPelicula"));
                pelicula.setCategoria(categoria);

                peliculas.add(pelicula);
            }
        } catch (ClassNotFoundException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error al cargar el classPath", ex);
            throw new BDException("Hubo un error al cargar el classPath", ex);
        } catch (SQLException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas.", ex);
            throw new BDException("Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas.", ex);
        } finally {
            this.getConexionDB().cerrarConexion();
            this.getConexionDB().cerrarPreparedStatement(preparedStam);
            this.getConexionDB().cerrarResultSet(rs);
        }
        return peliculas;
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) throws BDException {
        PreparedStatement preparedStam = null;
        try {
            preparedStam = this.getConexionDB().getConexion().prepareStatement(insertarPeliculaSQL);
            preparedStam.setString(1, pelicula.getNombre());
            preparedStam.setInt(2, pelicula.getDuracion());
            preparedStam.setString(3, pelicula.getDescripcion());
            preparedStam.setDate(4, new Date(pelicula.getAño().getTime()));
            preparedStam.setInt(5, pelicula.getCategoria().getId());
            preparedStam.executeUpdate();
        } catch (ClassNotFoundException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error al cargar el classPath", ex);
            throw new BDException("Hubo un error al cargar el classPath", ex);
        } catch (SQLException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas.", ex);
            throw new BDException("Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas", ex);
        } finally {
            this.getConexionDB().cerrarConexion();
            this.getConexionDB().cerrarPreparedStatement(preparedStam);
        }
    }

    @Override
    public List<Categoria> obtenerCategorias() throws BDException {
        List<Categoria> categorias = new ArrayList<>();
        PreparedStatement preparedStam = null;
        ResultSet rs = null;
        try {
            preparedStam = this.getConexionDB()
                    .getConexion().prepareStatement(obtenerCategoriasSQL);
            rs = preparedStam.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("idCategoria"));
                categoria.setNombre(rs.getString("nombreCategoria"));

                categorias.add(categoria);
            }
        } catch (ClassNotFoundException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error al cargar el classPath", ex);
            throw new BDException("Hubo un error al cargar el classPath", ex);
        } catch (SQLException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas.", ex);
            throw new BDException("Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas", ex);
        } finally {
            this.getConexionDB().cerrarConexion();
            this.getConexionDB().cerrarPreparedStatement(preparedStam);
            this.getConexionDB().cerrarResultSet(rs);
        }
        return categorias;
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) throws BDException {
        PreparedStatement preparedStam = null;
        try {
            preparedStam = this.getConexionDB().getConexion().prepareStatement(actualizarPeliculaSQL);
            preparedStam.setString(1, pelicula.getNombre());
            preparedStam.setInt(2, pelicula.getDuracion());
            preparedStam.setString(3, pelicula.getDescripcion());
            preparedStam.setDate(4, new Date(pelicula.getAño().getTime()));
            preparedStam.setInt(5, pelicula.getCategoria().getId());
            preparedStam.setInt(6, pelicula.getId());

            preparedStam.executeUpdate();
        } catch (ClassNotFoundException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error al cargar el classPath", ex);
            throw new BDException("Hubo un error al cargar el classPath", ex);
        } catch (SQLException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas.", ex);
            throw new BDException("Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas", ex);
        } finally {
            this.getConexionDB().cerrarConexion();
            this.getConexionDB().cerrarPreparedStatement(preparedStam);
        }
    }

    @Override
    public Pelicula obtenerPelicula(int id) throws BDException {
        Pelicula pelicula = null;
        PreparedStatement preparedStam = null;
        ResultSet rs = null;
        try {
            preparedStam = this.getConexionDB()
                    .getConexion().prepareStatement(obtenerPeliculaSQL);
            preparedStam.setInt(1, id);
            rs = preparedStam.executeQuery();
            while (rs.next()) {
                Categoria categoriaP = new Categoria();
                pelicula = new Pelicula();
                pelicula.setId(rs.getInt("idPelicula"));
                pelicula.setNombre(rs.getString("nombrePrelicula"));
                pelicula.setDuracion(rs.getInt("duracionPelicula"));
                pelicula.setDescripcion(rs.getString("descripcionPelicula"));
                pelicula.setAño(rs.getDate("añoPelicula"));

                categoriaP.setId(rs.getInt("idCategoria"));
                categoriaP.setNombre(rs.getString("nombreCategoria"));

                pelicula.setCategoria(categoriaP);
            }
        } catch (ClassNotFoundException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error al cargar el classPath", ex);
            throw new BDException("Hubo un error al cargar el classPath", ex);
        } catch (SQLException ex) {
            LoggerApp.severe("PeliculaDAOImpl - Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas.", ex);
            throw new BDException("Hubo un error de persistencia al tratar "
                    + "de obtener las peliculas", ex);
        } finally {
            this.getConexionDB().cerrarConexion();
            this.getConexionDB().cerrarPreparedStatement(preparedStam);
            this.getConexionDB().cerrarResultSet(rs);
        }
        return pelicula;
    }

    @Override
    public List<Alquiler> obtenerEstado() throws BDException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
