package com.ceiba.biblioteca.dao;

import com.ceiba.biblioteca.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 * Clase Dao crud
 * @author Mario Segura
 */
public interface PrestamoDao extends JpaRepository<Prestamo, Long>{
    List<Prestamo> findByIdUsuario(String nombre);
}
