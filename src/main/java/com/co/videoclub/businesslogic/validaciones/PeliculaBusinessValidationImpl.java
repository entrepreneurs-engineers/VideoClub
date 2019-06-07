package com.co.videoclub.businesslogic.validaciones;

import com.co.videoclub.persistencia.dto.Pelicula;
import com.co.videoclub.util.ValidadorExpresiones;

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
        if (!validarAño(String.valueOf(pelicula.getAño())).isEmpty()) {
            correcto = "No existe el año o esta incorrecto";
        }
        return correcto;
    }

    private String validarAño(String año) {
        String correcto = "";

        try {
            Integer.valueOf(año);
            if (!getValidador().validarExpresion("(([1][9][0-9][0-9])|([2][0-9][0-9][0-9]))", año)) {
                correcto = "el formato del año es incorrecto";
            }
        } catch (NumberFormatException | ClassCastException ex) {
            correcto = "el formato del año es incorrecto, cod-error: " + ex.getMessage();
        }

        return correcto;
    }

    private ValidadorExpresiones getValidador() {
        return ValidadorExpresiones.getValidadorExpresiones();
    }
}
