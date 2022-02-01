package com.ceiba.biblioteca.response;

/**
 * Clase de respuesta de peticiones
 * @author Mario Segura
 */
public class SuccessResponse {
    private long id;
    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
    private String fechaMaximaDevolucion;

    public SuccessResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    @Override
    public String toString() {
        return "SuccessResponse{" + "id=" + id + ", isbn=" + isbn + ", identificacionUsuario=" + identificacionUsuario + ", tipoUsuario=" + tipoUsuario + ", fechaMaximaDevolucion=" + fechaMaximaDevolucion + '}';
    }    
   
}
