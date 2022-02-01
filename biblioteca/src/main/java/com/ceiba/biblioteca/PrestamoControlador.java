package com.ceiba.biblioteca;


import com.ceiba.biblioteca.dto.PrestamoDto;
import com.ceiba.biblioteca.response.Mensaje;
import com.ceiba.biblioteca.response.MessagesResponse;
import com.ceiba.biblioteca.response.MensajeEnum;
import com.ceiba.biblioteca.response.SuccessResponse;
import com.ceiba.biblioteca.response.SuccessShortResponse;
import com.ceiba.biblioteca.service.PrestamoService;
import com.ceiba.biblioteca.util.UtilFunction;
import java.text.ParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase de controlador
 *
 * @author Mario Segura
 */
@RestController
@Slf4j
@RequestMapping("prestamo")
public class PrestamoControlador {

    public static final int USUARIO_AFILIADO = 1;
    public static final int USUARIO_EMPLEADO = 2;
    public static final int USUARIO_INVITADO = 3;
    
    MessagesResponse mensajeResponse;
    Mensaje mensaje;
    UtilFunction utilFunction;
    
    @Autowired
    private PrestamoService prestamoService;

    public PrestamoControlador(MessagesResponse mensajeResponse, Mensaje mensaje, UtilFunction utilFunction) {
        this.mensajeResponse = mensajeResponse;
        this.mensaje = mensaje;
        this.utilFunction = utilFunction;
    }
    
    @PostMapping("")
    public ResponseEntity<?> crearPrestamo(@RequestBody PrestamoDto prestamoDto) {
        try {
            if(!utilFunction.verificarTipoUsuario(prestamoDto)){
                mensaje = new Mensaje(
                        "Tipo de usuario no permitido en la biblioteca"); 
                return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
            }
            if(prestamoDto.getTipoUsuario() == USUARIO_INVITADO){
                mensajeResponse = utilFunction.getUserInvited(prestamoDto.getIdentificacionUsuario());
                if(!mensajeResponse.isError(mensajeResponse)){
                    if(!mensajeResponse.isInfo(mensajeResponse)){
                        mensaje = new Mensaje(mensajeResponse.getMensaje());
                        return new ResponseEntity<>(mensaje.getMensaje(), 
                                HttpStatus.BAD_REQUEST);
                    }
                }else{
                    return new ResponseEntity<>(mensajeResponse.getMensaje(), 
                            HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
            prestamoDto = utilFunction.calcularFecha(prestamoDto);
            prestamoDto = prestamoService.guardar(prestamoDto);            
            SuccessShortResponse successShortResponse = utilFunction.crearRespuestaCorta(prestamoDto);
            return new ResponseEntity<>(successShortResponse, HttpStatus.OK);
        } catch (ParseException e) {
            log.error("Error: " + e);
            String errorResponse = "No fue posible crear el usuario."; 
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{idPrestamo}")
    public ResponseEntity<?> getUserById(@PathVariable("idPrestamo") Long idPrestamo) throws ParseException{
        PrestamoDto prestamoDto = prestamoService.encontrarPrestamoPorId(idPrestamo);
        if(prestamoDto != null){
            SuccessResponse successResponse = utilFunction.crearRespuesta(prestamoDto);
            return new ResponseEntity<>(successResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

