package com.ceiba.biblioteca.response;

import org.springframework.stereotype.Component;

/**
 * Objeto de respuesta.
 * @author Mario Segura
 */
@Component
public class MessagesResponse {
    String mensaje;
    MensajeEnum tipoMensaje;
    
    public MessagesResponse() {
    }

    public MessagesResponse(String mensaje, MensajeEnum tipoMensaje) {
        this.mensaje = mensaje;
        this.tipoMensaje = tipoMensaje;
    }

    public boolean isError(MessagesResponse mensaje){
        if(mensaje.getTipoMensaje().equals(tipoMensaje.ERROR)){
            return true;
        }
        return false;
    }
    
    public boolean isInfo(MessagesResponse mensaje){
        if(mensaje.getTipoMensaje().equals(tipoMensaje.INFO)){
            return true;
        }
        return false;
    }
    
    public boolean isWarn(MessagesResponse mensaje){
        if(mensaje.getTipoMensaje().equals(tipoMensaje.WARNING)){
            return true;
        }
        return false;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public MensajeEnum getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(MensajeEnum tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }
    
    
}
