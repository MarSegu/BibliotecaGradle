package com.ceiba.biblioteca.dto;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase Dto utilizada para separar la capa de controlador 
 * de la capa de entidad.
 * 
 * @author Mario Segura
 */
public class PrestamoDto {
    
    private Long idPrestamo;
    
    private String isbn;
     
    private String identificacionUsuario; 
    
    private int tipoUsuario;
    
    private Date fechaEntrega;

    public PrestamoDto() {
    }

    public PrestamoDto(Long idPrestamo, String isbn, String identificacionUsuario, int tipoUsuario, Date fechaEntrega) {
        this.idPrestamo = idPrestamo;
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaEntrega = fechaEntrega;
    }

    public Long getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public String toString() {
        return "PrestamoDto{" + "idPrestamo=" + idPrestamo + ", isbn=" + isbn + ", identificacionUsuario=" + identificacionUsuario + ", tipoUsuario=" + tipoUsuario + ", fechaEntrega=" + fechaEntrega + '}';
    }
    
}
