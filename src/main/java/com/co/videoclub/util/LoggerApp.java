package com.co.videoclub.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esteban
 */
public class LoggerApp {
    private static final Logger LOGGER = Logger.getLogger(LoggerApp.class.getName());
    
    public static void info(String message){
        LOGGER.log(Level.INFO, message);
    }
    
    public static void info(String message, Throwable ex){
        LOGGER.log(Level.INFO, message, ex);
    }
    
    public static void warning(String message, Throwable ex){
        LOGGER.log(Level.WARNING, message, ex);
    }
    
    public static void severe(String message, Throwable ex){
        LOGGER.log(Level.SEVERE, message, ex);
    }
}
