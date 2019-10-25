package com.co.videoclub.persistencia.config;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.BDDMockito;
import static org.mockito.Matchers.anyString;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

/**
 *
 * @author davidesteban.gomez
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(JUnit4.class)
@PrepareForTest({DriverManager.class})
public class ConexionMySQLTest {
    
    private Conexion testConexion;
    
    @Before
    public void setUp(){
        testConexion = new ConexionMySQL();
    }
    
    /**
     * Test que trata de obtener la conexion pero devuelve 
     * un ClassNotFoundException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @Test(expected = SQLException.class)
    public void testQue_lanzaSQLException_cuando_intentaObtenerConexion() throws ClassNotFoundException, SQLException{
        //DADO
        PowerMockito.mockStatic(DriverManager.class);
        BDDMockito.given(DriverManager.getConnection(anyString(), anyString(), 
                anyString())).willThrow(SQLException.class);
        //CUANDO
        testConexion.getConexion();
        //ENTONCES
    }
}
