package com.ceiba.biblioteca.models;

import java.io.Serializable;
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
    @Column(name="isbn", length = 10)
    private String idPrestamo;
    
    @Column(name = "identificacionUsuario", length = 10)
    @NotEmpty  
    private String idUsuario; 
    
    @Column(length = 1)
    @NotNull
    private int tipoUsuario;
    
}
