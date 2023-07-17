package com.proyecto.app.spring.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.app.spring.entity.Proveedor;

public interface ProveedorService {
	public List<Proveedor> findByNombrePContaining(String nombreP);
	
	public List<Proveedor> findAll();
	
	public Optional<Proveedor> findById(Long idProveedor);
	
	public void save(Proveedor proveedor);
	
	public void deleteById(Long id);
}
