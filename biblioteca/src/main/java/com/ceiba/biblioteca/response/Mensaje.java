package com.ceiba.biblioteca.response;

import org.springframework.stereotype.Component;

/**
 * Objeto de respuesta de peticiones
 * @author Mario Segura
 */
@Component
public class Mensaje {
    String mensaje;

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
