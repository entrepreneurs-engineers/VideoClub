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
    private final SimpleDateFormat simpleDateFormat;
    
    public DateUtil(){
        this.simpleDateFormat = new SimpleDateFormat(FORMATO_FECHA_YYYYMMDD);
    }
    
    public Date convertirStringADate(String fecha) throws ParseException {
        return this.simpleDateFormat.parse(fecha);
    }    

    public void setFormatoFecha(String formatoFecha) {
        this.simpleDateFormat.applyPattern(formatoFecha);
    }
}
