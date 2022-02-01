package com.ceiba.biblioteca.mappers;

import com.ceiba.biblioteca.dto.PrestamoDto;
import com.ceiba.biblioteca.models.Prestamo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Clase de implementacion de interfaz de mapeo.
 *
 * @author Mario Segura
 */
@Component
public class PrestamoConverterImpl implements PrestamoConverter {

    private Prestamo prestamo;
    private PrestamoDto prestamoDto;
    private List<PrestamoDto> prestamosDto;
    
    public PrestamoConverterImpl() {
        this.prestamo = new Prestamo();
        this.prestamoDto = new PrestamoDto();
        this.prestamosDto = new ArrayList<>();
    }

    @Override
    public Prestamo convertPrestamoDtoToPrestamo(PrestamoDto prestamoDto) {
        if (prestamoDto != null) {
            this.prestamo.setIdPrestamo(prestamoDto.getIdPrestamo());
            this.prestamo.setIsbn(prestamoDto.getIsbn());
            this.prestamo.setIdentificacionUsuario(prestamoDto.getIdentificacionUsuario());
            this.prestamo.setTipoUsuario(prestamoDto.getTipoUsuario());
            this.prestamo.setFechaEntrega(prestamoDto.getFechaEntrega());
            return this.prestamo;
        } else {
            return null;
        }
    }

    @Override
    public PrestamoDto converterPrestamoToPrestamoDto(Prestamo prestamo) {
        if (prestamo != null) {
            this.prestamoDto.setIdPrestamo(prestamo.getIdPrestamo());
            this.prestamoDto.setIsbn(prestamo.getIsbn());
            this.prestamoDto.setIdentificacionUsuario(prestamo.getIdentificacionUsuario());
            this.prestamoDto.setTipoUsuario(prestamo.getTipoUsuario());
            this.prestamoDto.setFechaEntrega(prestamo.getFechaEntrega());
            return this.prestamoDto;
        } else {
            return null;
        }
    }

    @Override
    public List<PrestamoDto> converterPrestamosToPrestamosDto(List<Prestamo> prestamos) {
        this.prestamosDto = new ArrayList<>();
        if (prestamos != null) {
            for(Prestamo prestamo : prestamos){
                this.prestamoDto.setIdPrestamo(prestamo.getIdPrestamo());
                this.prestamoDto.setIsbn(prestamo.getIsbn());
                this.prestamoDto.setIdentificacionUsuario(prestamo.getIdentificacionUsuario());
                this.prestamoDto.setTipoUsuario(prestamo.getTipoUsuario());
                this.prestamoDto.setFechaEntrega(prestamo.getFechaEntrega());
                this.prestamosDto.add(this.prestamoDto);
            }
            return this.prestamosDto;
        } else {
            return null;
        }
    }

}
