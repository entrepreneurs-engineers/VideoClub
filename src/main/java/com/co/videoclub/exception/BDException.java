/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.co.videoclub.exception;

/**
 * Excepcion para controlar los errores 
 * en la capa de persistencia
 * @author davigofr
 */
public class BDException extends Exception{

	private static final long serialVersionUID = 1L;

	public BDException(String string) {
        super(string);
    }

    public BDException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public BDException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
