package com.ceiba.biblioteca.util;

import com.ceiba.biblioteca.dto.PrestamoDto;
import com.ceiba.biblioteca.response.MessagesResponse;
import com.ceiba.biblioteca.response.MensajeEnum;
import com.ceiba.biblioteca.response.SuccessResponse;
import com.ceiba.biblioteca.response.SuccessShortResponse;
import com.ceiba.biblioteca.service.PrestamoService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Clase utilizada para crear metodos de utilidad.
 *
 * @author Mario Segura
 */
@Component
@Slf4j
public class UtilFunction {

    @Autowired
    private PrestamoService prestamoService;

    /**
     *
     * @param nombre
     * @return
     */
    public MessagesResponse getUserInvited(String nombre) {
        List<PrestamoDto> prestamosDto = prestamoService.encontrarUsuariosPorNombre(nombre);
        if (prestamosDto != null) {
            if (!prestamosDto.isEmpty()) {
                PrestamoDto prestamoDto = new PrestamoDto();
                for (PrestamoDto prestamoForDto : prestamosDto) {
                    prestamoDto.setIdPrestamo(prestamoForDto.getIdPrestamo());
                    prestamoDto.setIdentificacionUsuario(prestamoForDto.getIdentificacionUsuario());
                    prestamoDto.setTipoUsuario(prestamoForDto.getTipoUsuario());
                }
                return new MessagesResponse("El usuario con identificación "
                        + prestamoDto.getIdentificacionUsuario() + " ya tiene un libro "
                        + "prestado por lo cual no se le puede realizar otro"
                        + " préstamo", MensajeEnum.WARNING);
            } else {
                return new MessagesResponse("El usuario no tiene prestamos activos.",
                        MensajeEnum.INFO);
            }
        }
        return new MessagesResponse("No fue posible validar si el usuario tiene prestamos "
                + "activos.", MensajeEnum.ERROR);
    }

    /**
     *
     * @param prestamoDto
     * @return
     */
    public PrestamoDto calcularFecha(PrestamoDto prestamoDto) {

        LocalDate fechaPrestamo = LocalDate.now();
        LocalDate result = fechaPrestamo;
        ZoneId defaultZoneId = ZoneId.systemDefault();
        int addedDays = 0;
        int diasPrestamo = 0;
        
        switch (prestamoDto.getTipoUsuario()) {
            case 1:
                diasPrestamo = 10;
                break;
            case 2:
                diasPrestamo = 8;
                break;
            default:
                diasPrestamo = 7;
                break;
        }
        
        while (addedDays < diasPrestamo) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        prestamoDto.setFechaEntrega(Date.from(result.atStartOfDay(defaultZoneId).toInstant()));
        return prestamoDto;

    }

    public boolean verificarTipoUsuario(PrestamoDto prestamoDto) {
        if (prestamoDto.getTipoUsuario() != 1
                && prestamoDto.getTipoUsuario() != 2
                && prestamoDto.getTipoUsuario() != 3) {
            log.error("El tipo de usuario no es valido.",
                    MensajeEnum.ERROR);
            return false;
        }
        log.info("El tipo de usuario es valido.",
                MensajeEnum.INFO);
        return true;
    }
    
    public SuccessResponse crearRespuesta(PrestamoDto prestamoDto) throws ParseException{
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.setId(prestamoDto.getIdPrestamo());
        successResponse.setIsbn(prestamoDto.getIsbn());
        successResponse.setIdentificacionUsuario(prestamoDto.getIdentificacionUsuario());
        successResponse.setTipoUsuario(prestamoDto.getTipoUsuario());
        successResponse.setFechaMaximaDevolucion(generarFechaRespuesta(prestamoDto));
        
        return successResponse;
    }
    
    public String generarFechaRespuesta(PrestamoDto prestamoDto) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = formatter.format(prestamoDto.getFechaEntrega()); 
        return fechaTexto;
    }
    
    public SuccessShortResponse crearRespuestaCorta(PrestamoDto prestamoDto) throws ParseException{
        SuccessShortResponse SuccessShortResponse = new SuccessShortResponse();
        SuccessShortResponse.setId(prestamoDto.getIdPrestamo());
        SuccessShortResponse.setFechaMaximaDevolucion(generarFechaRespuesta(prestamoDto));
        
        return SuccessShortResponse;
    }
}
