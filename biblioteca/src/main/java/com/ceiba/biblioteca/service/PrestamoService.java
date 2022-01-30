package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.dto.PrestamoDto;
import java.util.List;

/**
 * Clase CRUD
 * @author Mario Segura
 */
public interface PrestamoService {
    public void guardar(PrestamoDto prestamoDto);
    public List<PrestamoDto> encontrarUsuariosPorNombre(String nombre);
}
