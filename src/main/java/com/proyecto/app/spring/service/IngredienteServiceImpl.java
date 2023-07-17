package com.proyecto.app.spring.service;

import com.proyecto.app.spring.DAO.IngredienteDAO;
import com.proyecto.app.spring.entity.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteServiceImpl implements  IngredienteService{

    @Autowired
    private IngredienteDAO ingredienteDAO;
    @Override
    public List<Ingrediente> findAll() {
        return ingredienteDAO.findAll();
    }

    @Override
    public Optional<Ingrediente> findById(Long id) {
        return ingredienteDAO.findById(id);
    }

    @Override
    public void save(Ingrediente ingrediente) {
        ingredienteDAO.save(ingrediente);
    }

    @Override
    public void deleteById(Long id) {
        ingredienteDAO.deleteById(id);
    }
}
