package com.proyecto.app.spring.service;

import java.util.*;

import com.proyecto.app.spring.entity.Producto;

public interface ProductoService {
	
	public List<Producto> findAll();
	
	public Optional<Producto> findById(Long id);
	
	public void save(Producto producto);
	
	public void deleteById(Long Id);
}
