
package com.co.videoclub.persistencia.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author davigofr
 */
public interface Conexion {
    public Connection getConexion() throws ClassNotFoundException, SQLException;
    public void cerrarConexion();
    public void cerrarPreparedStatement(PreparedStatement preparedStam);
    public void cerrarResultSet(ResultSet resultSet);
}
