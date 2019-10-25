package com.co.videoclub.persistencia.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.co.videoclub.util.CargarPropiedades;
import com.co.videoclub.util.LoggerApp;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davigofr
 */
public class ConexionMySQL implements Conexion {

    private static final String DATA_BASE = "database";
    private static final String USUARIO = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String FILE_PROPERTIES = "src/main/Resources/config_db.properties";
    private Connection conexion = null;
    private static String dataBase;
    private static String usuario;
    private static String password;
    private static final CargarPropiedades CARGADOR = CargarPropiedades.getCargarPropiedades();

    static {
        try {
            CARGADOR.cargarPropiedades(FILE_PROPERTIES);
            dataBase = CARGADOR.getPropiedad(DATA_BASE);
            usuario = CARGADOR.getPropiedad(USUARIO);
            password = CARGADOR.getPropiedad(PASSWORD);
        } catch (IOException | URISyntaxException ex) {
            LoggerApp.severe("ConexionMySQL - Hubo un error al cargar el archivo de propiedades", ex);
        }
    }

    public ConexionMySQL() {
    }

    @Override
    public Connection getConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = DriverManager.getConnection(dataBase, usuario, password);
        return conexion;
    }

    @Override
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            LoggerApp.severe("ConexionMySQL - Hubo un error al cerrar la conexion: "
                    + ex.getMessage(), ex);
        }
    }

    @Override
    public void cerrarPreparedStatement(PreparedStatement preparedStam) {
        try {
            if (preparedStam != null && !preparedStam.isClosed()) {
                preparedStam.close();
            }
        } catch (SQLException ex) {
            LoggerApp.severe("ConexionMySQL - Hubo un error al cerrar el preparedStament: "
                    + ex.getMessage(), ex);
        }
    }

    @Override
    public void cerrarResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            LoggerApp.severe("ConexionMySQL - Hubo un error al cerrar el ResultSet: "
                    + ex.getMessage(), ex);
        }
    }
}
