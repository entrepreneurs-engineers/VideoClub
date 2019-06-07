
package com.co.videoclub.util;

import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author davigofr
 */
public class ValidadorExpresionesTest {
    
    private static final ValidadorExpresiones VALIDADOR = ValidadorExpresiones.getValidadorExpresiones();
    
    @Test
    public void validarExpresionMenorA2000(){
        boolean correcto = VALIDADOR.
                validarExpresion("(([1][9][0-9][0-9])|([2][0-9][0-9][0-9]))", "1990");
        assert correcto;
    }
    
    @Test
    public void validarExpresionMayorA2000(){
        boolean correcto = VALIDADOR.
                validarExpresion("(([1][9][0-9][0-9])|([2][0-9][0-9][0-9]))", "2017");
        assert correcto;
    }
    
    @Test 
    public void añoErrado1(){
        boolean correcto = VALIDADOR.
                validarExpresion("(([1][9][0-9][0-9])|([2][0-9][0-9][0-9]))", "3017");
        
        Assert.assertFalse(correcto);
    }
    
    @Test 
    public void añoErrado2(){
        boolean correcto = VALIDADOR.
                validarExpresion("(([1][9][0-9][0-9])|([2][0-9][0-9][0-9]))", "199c");
        
        Assert.assertFalse(correcto);
    }
}
