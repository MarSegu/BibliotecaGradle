package com.ceiba.biblioteca.dto;

/**
 * Clase Dto utilizada para separar la capa de controlador 
 * de la capa de entidad.
 * 
 * @author Mario Segura
 */
public class PrestamoDto {
    
    private String idPrestamo;
     
    private String idUsuario; 
    
    private int tipoUsuario;

    public PrestamoDto() {
    }

    public PrestamoDto(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public PrestamoDto(String idPrestamo, String idUsuario, int tipoUsuario) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "PrestamoDto{" + "idPrestamo=" + idPrestamo + ", idUsuario=" + idUsuario + ", tipoUsuario=" + tipoUsuario + '}';
    }    
    
}
