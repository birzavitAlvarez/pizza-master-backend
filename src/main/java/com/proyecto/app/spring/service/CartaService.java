package com.proyecto.app.spring.service;

import com.proyecto.app.spring.entity.Carta;

import java.util.List;
import java.util.Optional;

public interface CartaService {
    public List<Carta> findAll();

    public Optional<Carta> findById(Long id);

    public void save(Carta carta);

    public void deleteById(Long id);
}
