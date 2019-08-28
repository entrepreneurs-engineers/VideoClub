package com.co.videoclub.util;

import java.text.ParseException;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author davidesteban.gomez
 */
public class DateUtilTest {
    
    private DateUtil testDateUtil;
    
    @Before
    public void setUp(){
        testDateUtil = new DateUtil();
    }
    
    /**
     * Test que convierte un objeto de tipo
     * String a uno de tipo Date acorde al formato
     * de fecha por default YYYY-MM-DD
     * @throws java.text.ParseException
     */
    @Test
    public void testQue_convierteStringADate_cuando_elFormatoEsDefault()
            throws ParseException{
        //DADO
        final long fechaMilisegundos = 1542690000000L;
        final String fecha = "2018-11-20";
        //CUANDO
        Date fechaObtenida = testDateUtil.convertirStringADate(fecha);
        //ENTONCES
        Assert.assertEquals(fechaMilisegundos, fechaObtenida.getTime());
    }
    
    /**
     * Test que intenta convertir un objeto de tipo
     * String a uno de tipo Date acorde al formato
     * de fecha por default YYYY-MM-DD pero falla porque el objeto fecha
     * tiene un formato errado
     * @throws java.text.ParseException
     */
    @Test(expected = ParseException.class)
    public void testQue_lanzaParseException_cuando_laFechaNoEsAcordeAlFormato()
            throws ParseException{
        //DADO
        final String fecha = "254214141215993";
         //CUANDO
        testDateUtil.convertirStringADate(fecha);
        //ENTONCES
    }
    
    /**
     * Test que convierte un objeto de tipo
     * String a uno de tipo Date acorde al formato
     * de fecha especificado (EJ: dd-MM-yyyy)
     * @throws java.text.ParseException
     */
    @Test
    public void testQue_convierteStringADate_cuando_elFormatoEsEspecificado()
            throws ParseException{
        //DADO
        final long fechaMilisegundos = 1542690000000L;
        final String fecha = "20-11-2018";
        
        testDateUtil.setFormatoFecha("dd-MM-yyyy");
        testDateUtil.setPatronFecha("^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)\\d{4}$");
        //CUANDO
        Date fechaObtenida = testDateUtil.convertirStringADate(fecha);
        //ENTONCES
        Assert.assertEquals(fechaMilisegundos, fechaObtenida.getTime());
    }
    
    /**
     * Test que intenta convertir un objeto de tipo
     * String a uno de tipo Date acorde al formato
     * de fecha por default YYYY-MM-DD pero falla porque el objeto formato
     * es errado
     * @throws java.text.ParseException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testQue_lanzaParseException_cuando_formatoEsErrado()
            throws ParseException{
        //DADO
        final String fecha = "20-11-2018";
  
        testDateUtil.setFormatoFecha("dsd-MsM-yyfgyy");
        //CUANDO
        testDateUtil.convertirStringADate(fecha);
        //ENTONCES
    }
    
    /**
     * Test que devuelve la fecha en tipo String 
     * en el formato estandar
     */
    @Test
    public void testQue_devuelveFechaFormatoEstandar_return_String(){
        //DADO
        final String fechaEsperada = "2018-11-20";
        final Date fechaEnviada = new Date(1542690000000L);
        //CUANDO
        String fechaActual = testDateUtil.convertirDateAString(fechaEnviada);
        //ENTONCES
        Assert.assertEquals(fechaEsperada, fechaActual);
    }
}
