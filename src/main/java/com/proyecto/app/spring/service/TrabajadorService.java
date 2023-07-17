package com.proyecto.app.spring.service;

import java.util.*;

import com.proyecto.app.spring.entity.Trabajador;

public interface TrabajadorService {
	public List<Trabajador> findAll();
	public Optional<Trabajador> findById(Long id);
	public void save(Trabajador trabajador);
	public void deleteById(Long id);
}
