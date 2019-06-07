package com.co.videoclub.util;

import java.text.ParseException;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author davidesteban.gomez
 */
public class DateUtilTest {
    
    private DateUtil testDateUtil;
    
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
  
        testDateUtil = new DateUtil();
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
 
        testDateUtil = new DateUtil();
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
  
        testDateUtil = new DateUtil();
        testDateUtil.setFormatoFecha("dd-MM-yyyy");
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
  
        testDateUtil = new DateUtil();
        testDateUtil.setFormatoFecha("dsd-MsM-yyfgyy");
        //CUANDO
        testDateUtil.convertirStringADate(fecha);
        //ENTONCES
    }
}
