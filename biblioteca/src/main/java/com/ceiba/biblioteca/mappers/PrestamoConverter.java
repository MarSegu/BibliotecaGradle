package com.ceiba.biblioteca.mappers;

import com.ceiba.biblioteca.dto.PrestamoDto;
import com.ceiba.biblioteca.models.Prestamo;
import java.util.List;

/**
 * Clase de mapeo de DTO a Entity.
 * @author Mario Segura
 */
public interface PrestamoConverter {
    
    Prestamo convertPrestamoDtoToPrestamo(PrestamoDto prestamoDto);

    PrestamoDto converterPrestamoToPrestamoDto(Prestamo prestamo);
    
    List<PrestamoDto> converterPrestamosToPrestamosDto(List<Prestamo> prestamos);
            
}
