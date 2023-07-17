package com.proyecto.app.spring.service;


import com.proyecto.app.spring.entity.Detalle;

import java.util.List;
import java.util.Optional;

public interface DetalleService {
    public List<Detalle> findAll();

    public Optional<Detalle> findById(Long id);

    public void save(Detalle detalle);

    public void deleteById(Long id);
}
