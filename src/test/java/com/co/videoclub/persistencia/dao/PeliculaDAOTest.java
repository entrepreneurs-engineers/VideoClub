package com.co.videoclub.persistencia.dao;

import com.co.videoclub.exception.BDException;
import com.co.videoclub.persistencia.config.Conexion;
import com.co.videoclub.persistencia.dto.Categoria;
import com.co.videoclub.persistencia.dto.Pelicula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

/**
 *
 * @author esteban
 */
public class PeliculaDAOTest {
    
    private PeliculaDAO peliculaDao;
    
    final private Conexion mockConexion = Mockito.mock(Conexion.class);
    private Pelicula pelicula;
    
    @Before
    public void setUp(){
        peliculaDao = new PeliculaDAOImpl();
        
        pelicula = new Pelicula();
        pelicula.setId(112);
        pelicula.setNombre("La mascara");
        pelicula.setDescripcion("Mascara verde que da poderes");
        pelicula.setDuracion(90);
        pelicula.setCategoria(new Categoria(1002, "Comedia"));
        pelicula.setAño(new java.util.Date());
    }
    
    @Test
    public void pruebaQue_devuelvePeliculas() throws BDException, ClassNotFoundException, SQLException{
        //DADO
        Date fecha = new java.sql.Date(01201301L);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Connection mockConnection = Mockito.mock(Connection.class);
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Matchers.any(String.class))).thenReturn(mockPreparedStatement);
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        
        Mockito.when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockResultSet.getInt("idCategoria")).thenReturn(1);
        Mockito.when(mockResultSet.getString("nombreCategoria")).thenReturn("Suspenso");
        Mockito.when(mockResultSet.getInt("idPelicula")).thenReturn(11);
        Mockito.when(mockResultSet.getString("nombrePrelicula")).thenReturn("Mentiroso mentiroso");
        Mockito.when(mockResultSet.getInt("duracionPelicula")).thenReturn(90);
        Mockito.when(mockResultSet.getString("descripcionPelicula")).thenReturn("Jim Carrey gracioso");
        Mockito.when(mockResultSet.getDate("añoPelicula")).thenReturn(fecha);
        
        List<Pelicula> peliculas = peliculaDao.obtenerPeliculas();
        //ENTONCES
        assert peliculas.size() == 1;
        assert peliculas.get(0).getNombre().equals("Mentiroso mentiroso");
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_devuelvePeliculas_GeneraExceptionPorConexion()
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(SQLException.class);
        
        peliculaDao.obtenerPeliculas();
        //ENTONCES
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_devuelvePeliculas_GeneraExceptionPorClassPath()
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(ClassNotFoundException.class);
        
        peliculaDao.obtenerPeliculas();
        //ENTONCES
    }
    
    @Test
    public void pruebaQue_AgregaPelicula()
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Connection mockConnection = Mockito.mock(Connection.class);
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Matchers.any(String.class))).thenReturn(mockPreparedStatement);
        Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        
        peliculaDao.agregarPelicula(pelicula);
        //ENTONCES
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_AgregaPelicula_LanzaExceptionPorConexion() 
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(SQLException.class);
        
        peliculaDao.agregarPelicula(pelicula);
        //ENTONCES
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_AgregaPelicula_GeneraExceptionPorClassPath() 
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(ClassNotFoundException.class);
        
        peliculaDao.agregarPelicula(pelicula);
        //ENTONCES
    }
    
    @Test
    public void pruebaQue_devuelveCategorias() throws BDException, ClassNotFoundException, SQLException{
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Connection mockConnection = Mockito.mock(Connection.class);
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Matchers.any(String.class))).thenReturn(mockPreparedStatement);
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        
        Mockito.when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockResultSet.getInt("idCategoria")).thenReturn(1);
        Mockito.when(mockResultSet.getString("nombreCategoria")).thenReturn("Comedia");
        
        List<Categoria> categorias = peliculaDao.obtenerCategorias();
        //ENTONCES
        assert categorias.size() == 1;
        assert categorias.get(0).getNombre().equals("Comedia");
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_DevuelveCategorias_LanzaExceptionPorConexion() 
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(SQLException.class);
        
        peliculaDao.obtenerCategorias();
        //ENTONCES
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_DevuelveCategorias_GeneraExceptionPorClassPath() 
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(ClassNotFoundException.class);
        
        peliculaDao.obtenerCategorias();
        //ENTONCES
    }
    
    @Test
    public void pruebaQue_ActualizaPelicula()
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Connection mockConnection = Mockito.mock(Connection.class);
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Matchers.any(String.class))).thenReturn(mockPreparedStatement);
        Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        
        peliculaDao.actualizarPelicula(pelicula);
        //ENTONCES
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_ActualizaPelicula_LanzaExceptionPorConexion() 
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(SQLException.class);
        
        peliculaDao.actualizarPelicula(pelicula);
        //ENTONCES
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_ActualizaPelicula_GeneraExceptionPorClassPath() 
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(ClassNotFoundException.class);
        
        peliculaDao.actualizarPelicula(pelicula);
        //ENTONCES
    }
    
    @Test
    public void pruebaQue_devuelvePeliculaEspecifica() throws BDException, ClassNotFoundException, SQLException{
        //DADO
        Date fecha = new java.sql.Date(01201301L);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
        Connection mockConnection = Mockito.mock(Connection.class);
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenReturn(mockConnection);
        Mockito.when(mockConnection.prepareStatement(Matchers.any(String.class))).thenReturn(mockPreparedStatement);
        Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        
        Mockito.when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(mockResultSet.getInt("idCategoria")).thenReturn(1);
        Mockito.when(mockResultSet.getString("nombreCategoria")).thenReturn("Suspenso");
        Mockito.when(mockResultSet.getInt("idPelicula")).thenReturn(11);
        Mockito.when(mockResultSet.getString("nombrePrelicula")).thenReturn("Mentiroso mentiroso");
        Mockito.when(mockResultSet.getInt("duracionPelicula")).thenReturn(90);
        Mockito.when(mockResultSet.getString("descripcionPelicula")).thenReturn("Jim Carrey gracioso");
        Mockito.when(mockResultSet.getDate("añoPelicula")).thenReturn(fecha);
        
        Pelicula peliculaExpected = peliculaDao.obtenerPelicula(19);
        //ENTONCES
        assert peliculaExpected.getId() == 11;
        assert peliculaExpected.getNombre().equals("Mentiroso mentiroso");
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_devuelvePeliculaEspecifica_LanzaExceptionPorConexion() 
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(SQLException.class);
        
        peliculaDao.obtenerPelicula(19);
        //ENTONCES
    }
    
    @Test(expected = BDException.class)
    public void pruebaQue_devuelvePeliculaEspecifica_GeneraExceptionPorClassPath() 
            throws BDException, ClassNotFoundException, SQLException{
        //DADO
        peliculaDao.setConexionDB(mockConexion);
        //CUANDO
        Mockito.when(mockConexion.getConexion()).thenThrow(ClassNotFoundException.class);
        
        peliculaDao.obtenerPelicula(19);
        //ENTONCES
    }
}
