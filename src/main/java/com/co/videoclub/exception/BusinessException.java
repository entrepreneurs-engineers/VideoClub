
package com.co.videoclub.exception;

/**
 * Excepcion para controlar los errores
 * en la capa de validaciones
 * @author davigofr
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String string) {
        super(string);
    }

    public BusinessException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
