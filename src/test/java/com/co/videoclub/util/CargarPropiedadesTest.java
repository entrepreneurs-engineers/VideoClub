package com.co.videoclub.util;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author davigofr
 */
public class CargarPropiedadesTest {

    private static final CargarPropiedades CARGADOR = CargarPropiedades.getCargarPropiedades();

    /**
     * Test que comprueba que el archivo de propiedades si cargo correctamente
     */
    @Test
    public void conArchivoPropiedades() {
        try {
            String fileProperties = "config_db_test.properties";
            CARGADOR.cargarPropiedades(fileProperties);
        } catch (IOException ex) {
            fail("No se encontró archivo, cod: " + ex.getMessage());
        }
    }

    /**
     * Test que prueba que no existe archivo de propiedades, se expera que lance
     * una excepcion (IOException)
     *
     * @throws java.io.IOException
     */
    @Test(expected = IOException.class)
    public void noExisteArchivoPropiedades() throws IOException {
        String fileProperties = "config_db_test2s.properties";
        CARGADOR.cargarPropiedades(fileProperties);
    }

    /**
     * Test que comprueba que si se envia una propiedad con key vacio, el valor
     * de la key será null
     */
    @Test
    public void obtenerPropiedadVacia() {
        try {
            String fileProperties = "config_db_test.properties";
            String DATA_BASE = "";
            CARGADOR.cargarPropiedades(fileProperties);
            String dataBase = CARGADOR.getPropiedad(DATA_BASE);

            assertEquals(null, dataBase);
        } catch (IOException ex) {
            fail("Hubo un error con la lectura del archivo, "
                    + "cod: " + ex.getMessage());
        }
    }

    /**
     * Test que comprueba que si se envia una propiedad con key null, el valor
     * de la key será null
     */
    @Test
    public void obtenerPropiedadNula() {
        try {
            String fileProperties = "config_db_test.properties";
            String DATA_BASE = null;
            CARGADOR.cargarPropiedades(fileProperties);
            String dataBase = CARGADOR.getPropiedad(DATA_BASE);

            assertEquals(null, dataBase);
        } catch (IOException ex) {
            fail("Hubo un error con la lectura del archivo, "
                    + "cod: " + ex.getMessage());
        }
    }

    /**
     * Test que comprueba que todas las propiedades
     * esten correctas
     */
    @Test
    public void obtenerPropiedadesCorrectas() {
        try {
            String fileProperties = "config_db_test.properties";
            String DATA_BASE = "database";
            String USUARIO = "dbuser";
            String PASSWORD = "dbpassword";
            CARGADOR.cargarPropiedades(fileProperties);
            String dataBase = CARGADOR.getPropiedad(DATA_BASE);
            String usuario = CARGADOR.getPropiedad(USUARIO);
            String password = CARGADOR.getPropiedad(PASSWORD);

            assertEquals("mysql_test", dataBase);
            assertEquals("test", usuario);
            assertEquals("test", password);
        } catch (IOException ex) {
            fail("No se encontró archivo, cod: " + ex.getMessage());
        }
    }
}
