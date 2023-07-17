package com.proyecto.app.spring.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.app.spring.DAO.ProductoDAO;
import com.proyecto.app.spring.entity.Producto;



@Service
public class ProductoServiceImpl implements ProductoService{
	@Autowired
	private ProductoDAO productoDAO;

	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		return productoDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Producto> findById(Long Id) {
		return productoDAO.findById(Id);
	}

	@Override
	@Transactional
	public void save(Producto producto) {
		productoDAO.save(producto);
	}

	@Override
	@Transactional
	public void deleteById(Long Id) {
		productoDAO.deleteById(Id);
	}
}
