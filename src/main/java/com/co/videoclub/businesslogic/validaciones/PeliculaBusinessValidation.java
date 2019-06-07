package com.co.videoclub.businesslogic.validaciones;

import com.co.videoclub.persistencia.dto.Pelicula;

/**
 *
 * @author davigofr
 */
public interface PeliculaBusinessValidation {
    public String validarCamposObligatorios(Pelicula pelicula);
}
