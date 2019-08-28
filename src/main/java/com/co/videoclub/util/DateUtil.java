package com.co.videoclub.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author teban25
 */
public class DateUtil {

    public final String FORMATO_FECHA_YYYYMMDD = "yyyy-MM-dd";
    private String patronFecha = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    private final SimpleDateFormat simpleDateFormat;    
    
    public DateUtil(){
        this.simpleDateFormat = new SimpleDateFormat(FORMATO_FECHA_YYYYMMDD);
    }
    
    public Date convertirStringADate(String fecha) throws ParseException {
        if(!ValidadorExpresiones.getValidadorExpresiones().validarExpresion(this.patronFecha, 
                fecha)){
            throw new ParseException("El formato de fecha es errado, cambielo o "
                    + "envie la fecha correctamente",1);
        }
        
        return this.simpleDateFormat.parse(fecha);
    }    

    public void setFormatoFecha(String formatoFecha) {
        this.simpleDateFormat.applyPattern(formatoFecha);
    }
    
    public void setPatronFecha(String patronFecha){
        this.patronFecha = patronFecha;
    }

    public String convertirDateAString(Date date) {
        return this.simpleDateFormat.format(date);
    }
}
