package com.ceiba.biblioteca;


import com.ceiba.biblioteca.dto.PrestamoDto;
import com.ceiba.biblioteca.response.Mensaje;
import com.ceiba.biblioteca.response.MensajeEnum;
import com.ceiba.biblioteca.service.PrestamoService;
import java.util.List;
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

    Mensaje mensaje;
    MensajeEnum mensajeEnum;
    
    @Autowired
    private PrestamoService prestamoService;
    
    @PostMapping("/crear")
    public ResponseEntity<?> crearPrestamo(@RequestBody PrestamoDto prestamoDto) {
        try {
            if(prestamoDto.getTipoUsuario() == 3){
                mensaje = getUserInvited(prestamoDto.getIdUsuario());
                if(!mensaje.isError(mensaje)){
                    if(!mensaje.isInfo(mensaje)){
                        return new ResponseEntity<>(mensaje.getMensaje(), 
                                HttpStatus.BAD_REQUEST);
                    }
                }else{
                    return new ResponseEntity<>(mensaje.getMensaje(), 
                            HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }            
            
            prestamoService.guardar(prestamoDto);
            String response = "Prestamo Creado exitosamente";
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error: " + e);
            String errorResponse = "No fue posible crear el usuario."; 
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/encontrar/{nombre}")
    public ResponseEntity<?> getUserByName(@PathVariable("nombre") String nombre) {
        List<PrestamoDto> prestamosDto = prestamoService.encontrarUsuariosPorNombre(nombre);
        if (prestamosDto != null) {
            if (!prestamosDto.isEmpty()) {
                return new ResponseEntity<>(prestamosDto, HttpStatus.OK);
            } else {
                String errorResponse = "El usuario no fue encontrado."; 
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }
        }
        String errorResponse = "No fue posible realizar la consulta."; 
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    public Mensaje getUserInvited(String nombre) {
        List<PrestamoDto> prestamosDto = prestamoService.encontrarUsuariosPorNombre(nombre);
        if (prestamosDto != null) {
            if (!prestamosDto.isEmpty()) {
                PrestamoDto prestamoDto = new PrestamoDto();
                for(PrestamoDto prestamoForDto: prestamosDto){
                    prestamoDto.setIdPrestamo(prestamoForDto.getIdPrestamo());
                    prestamoDto.setIdUsuario(prestamoForDto.getIdUsuario());
                    prestamoDto.setTipoUsuario(prestamoForDto.getTipoUsuario());
                }
                return new Mensaje("El usuario con identificacion " 
                                + prestamoDto.getIdUsuario() + " ya tiene un libro "
                                + "prestado por lo cual no se le puede realizar otro"
                                        + "prestamo", mensajeEnum.WARNING);
            } else {
                return new Mensaje("El usuario no tiene prestamos activos.", 
                        mensajeEnum.INFO);
            }
        }
        return new Mensaje("No fue posible validar si el usuario tiene prestamos "
                + "activos.", mensajeEnum.ERROR);
    }
}

