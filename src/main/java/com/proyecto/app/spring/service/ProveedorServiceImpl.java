package com.proyecto.app.spring.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.app.spring.DAO.ProveedorDAO;
import com.proyecto.app.spring.entity.Proveedor;
@Service
public class ProveedorServiceImpl implements ProveedorService{
	@Autowired
	private ProveedorDAO proveedorDAO;
	@Override
	@Transactional(readOnly=true)
	public List<Proveedor> findByNombrePContaining(String nombreP) {
		return proveedorDAO.findByNombrePContaining(nombreP);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Proveedor> findAll() {
		return proveedorDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Proveedor> findById(Long idProveedor) {
		return proveedorDAO.findById(idProveedor);
	}

	@Override
	@Transactional
	public void save(Proveedor proveedor) {
		 proveedorDAO.save(proveedor);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		proveedorDAO.deleteById(id);
	}
	
}
