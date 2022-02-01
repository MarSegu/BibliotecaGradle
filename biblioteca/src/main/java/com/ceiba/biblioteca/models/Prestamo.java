package com.ceiba.biblioteca.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase de la entidad prestamo.
 * 
 * @author Mario Segura
 */
@Data
@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;
    
    @Column(name="isbn", length = 10)
    private String isbn;
    
    @Column(length = 10)
    @NotEmpty  
    private String identificacionUsuario; 
    
    @Column(length = 1)
    @NotNull
    private int tipoUsuario;
    
    @NotNull
    private Date fechaEntrega;
    
}
