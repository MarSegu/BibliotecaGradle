package com.ceiba.biblioteca.service;

import com.ceiba.biblioteca.dao.PrestamoDao;
import com.ceiba.biblioteca.dto.PrestamoDto;
import com.ceiba.biblioteca.mappers.PrestamoConverterImpl;
import com.ceiba.biblioteca.models.Prestamo;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void guardar(PrestamoDto prestamoDto) {
        prestamo = prestamoConverterImpl.convertPrestamoDtoToPrestamo(prestamoDto);
        prestamoDao.save(prestamo);
    }

    @Override
    public List<PrestamoDto> encontrarUsuariosPorNombre(String nombre) {
        this.prestamos = prestamoDao.findByIdUsuario(nombre);
        return prestamoConverterImpl.converterPrestamosToPrestamosDto(this.prestamos);
    }

}
