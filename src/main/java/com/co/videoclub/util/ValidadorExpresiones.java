package com.co.videoclub.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author davigofr
 */
public class ValidadorExpresiones {
    private Pattern pattern;
    private Matcher matcher;
    private static ValidadorExpresiones validadorExpre;
    
    private ValidadorExpresiones(){
    }
    
    public static ValidadorExpresiones getValidadorExpresiones(){
        if(validadorExpre == null){
            validadorExpre = new ValidadorExpresiones();
        }
        return validadorExpre;
    }
    
    public boolean validarExpresion(String patron, String entrada){
        boolean comprobado = false;
        this.pattern = Pattern.compile(patron);
        this.matcher = getPattern().matcher(entrada);
        if(getMatcher().find()){
            comprobado = true;
        }
        return comprobado;
    }

    private Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    private Matcher getMatcher() {
        return matcher;
    }

    public void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }
}
