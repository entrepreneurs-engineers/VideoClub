package com.co.videoclub.businesslogic.validaciones;

import com.co.videoclub.persistencia.dto.Pelicula;

/**
 *
 * @author davigofr
 */
public class PeliculaBusinessValidationImpl implements PeliculaBusinessValidation {

    /**
     * Valida si los campos obligatorios de la pelicula estan correctos
     *
     * @param pelicula
     * @return
     */
    @Override
    public String validarCamposObligatorios(Pelicula pelicula) {
        String correcto = "";
        if (pelicula.getNombre() == null || pelicula.getNombre().isEmpty()) {
            correcto = "No existe nombre";
        }
        if (!(pelicula.getDuracion() > 0)) {
            correcto = "No existe la duracion o no es correcta";
        }
        if (pelicula.getAño() == null) {
            correcto = "No existe el año o esta incorrecto";
        }
        return correcto;
    }
}
