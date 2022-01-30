package com.ceiba.biblioteca.response;

/**
 * Objeto de respuesta de peticiones
 * @author Mario Segura
 */
public class Mensaje {
    String mensaje;
    MensajeEnum tipoMensaje;
    
    public Mensaje() {
    }

    public Mensaje(String mensaje, MensajeEnum tipoMensaje) {
        this.mensaje = mensaje;
        this.tipoMensaje = tipoMensaje;
    }

    public boolean isError(Mensaje mensaje){
        if(mensaje.getTipoMensaje().equals(tipoMensaje.ERROR)){
            return true;
        }
        return false;
    }
    
    public boolean isInfo(Mensaje mensaje){
        if(mensaje.getTipoMensaje().equals(tipoMensaje.INFO)){
            return true;
        }
        return false;
    }
    
    public boolean isWarn(Mensaje mensaje){
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
