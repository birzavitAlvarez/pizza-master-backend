package com.proyecto.app.spring.service;

import com.proyecto.app.spring.entity.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface IngredienteService {
    public List<Ingrediente> findAll();

    public Optional<Ingrediente> findById(Long id);

    public void save(Ingrediente ingrediente);

    public void deleteById(Long id);
}
