package com.ceiba.biblioteca.response;

/**
 * Clase de respuesta corta de peticiones.
 * @author Mario Segura
 */
public class SuccessShortResponse {
    
    private long id;
    private String fechaMaximaDevolucion;

    public SuccessShortResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(String fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }

    @Override
    public String toString() {
        return "SuccessShortResponse{" + "id=" + id + ", fechaMaximaDevolucion=" + fechaMaximaDevolucion + '}';
    }
    
}
