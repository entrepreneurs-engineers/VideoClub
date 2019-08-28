package com.co.videoclub.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 *
 * @author davigofr
 */
public class CargarPropiedades {

    private Properties propiedades;
    private InputStream input;
    private static CargarPropiedades cargarPropiedades;

    private CargarPropiedades() {
        propiedades = new Properties();
    }

    public static CargarPropiedades getCargarPropiedades() {
        if (cargarPropiedades == null) {
            cargarPropiedades = new CargarPropiedades();
        }
        return cargarPropiedades;
    }

    public void cargarPropiedades(String nombreArchivo) throws IOException, URISyntaxException {
        try {
            String ruta = getClass().getProtectionDomain().getCodeSource()
                    .getLocation().toURI().getPath().split("target/")[0];
            input = new FileInputStream(new File(ruta,nombreArchivo));
            
            if (input == null) {
                throw new IOException("No se logró cargar el archivo");
            }

            propiedades.load(input);
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }finally{
            if (input != null){
                input.close();
            }
        }
    }
    
    public String getPropiedad(String propiedad){
        if(propiedad == null || propiedad.isEmpty()){
            return null;
        }
        
        return propiedades.getProperty(propiedad);
    }

    public void setPropiedades(Properties propiedades) {
        this.propiedades = propiedades;
    }
}
