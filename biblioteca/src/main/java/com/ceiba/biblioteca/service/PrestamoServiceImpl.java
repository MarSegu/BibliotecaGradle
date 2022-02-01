package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.dao.PrestamoDao;
import com.ceiba.biblioteca.dto.PrestamoDto;
import com.ceiba.biblioteca.mappers.PrestamoConverterImpl;
import com.ceiba.biblioteca.models.Prestamo;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase de implementacion CRUD
 * @author Mario Segura
 */
@Service
@NoArgsConstructor
public class PrestamoServiceImpl implements PrestamoService{
    
    private PrestamoConverterImpl prestamoConverterImpl;
    private Prestamo prestamo;
    private PrestamoDao prestamoDao;   
    private List<Prestamo> prestamos;
    
    @Autowired
    public PrestamoServiceImpl(PrestamoConverterImpl prestamoConverterImpl, PrestamoDao prestamoDao) {
        this.prestamoConverterImpl = prestamoConverterImpl;
        this.prestamoDao = prestamoDao;
    }    
    
    @Override 
    public PrestamoDto guardar(PrestamoDto prestamoDto) {        
        this.prestamo = prestamoDao.save(prestamoConverterImpl.convertPrestamoDtoToPrestamo(prestamoDto));
        return prestamoConverterImpl.converterPrestamoToPrestamoDto(this.prestamo);
    }

    @Override
    public List<PrestamoDto> encontrarUsuariosPorNombre(String nombre) {
        this.prestamos = prestamoDao.findByIdentificacionUsuario(nombre);
        return prestamoConverterImpl.converterPrestamosToPrestamosDto(this.prestamos);
    }
    
    @Override
    @Transactional(readOnly = true)
    public PrestamoDto encontrarPrestamoPorId(Long idPrestamo) {        
        this.prestamo = prestamoDao.findByIdPrestamo(idPrestamo);        
        return prestamoConverterImpl.converterPrestamoToPrestamoDto(this.prestamo);
    }

}
