package com.proyecto.app.spring.service;

import com.proyecto.app.spring.entity.Comprobantes;

import java.util.List;
import java.util.Optional;


public interface ComprobantesService {
    public List<Comprobantes> findAll();
    public Optional<Comprobantes> findById(Long id);
    public void save(Comprobantes comprobantes);
    public void deleteById(Long id);

}
