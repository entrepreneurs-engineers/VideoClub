
package com.co.videoclub.exception;

/**
 * Excepcion para controlar los errores
 * en la capa de validaciones
 * @author davigofr
 */
public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BusinessException(String string) {
        super(string);
    }

    public BusinessException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
