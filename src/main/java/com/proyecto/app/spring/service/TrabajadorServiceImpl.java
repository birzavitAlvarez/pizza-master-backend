package com.proyecto.app.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.app.spring.DAO.TrabajadorDAO;
import com.proyecto.app.spring.entity.Trabajador;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {
	@Autowired
	private TrabajadorDAO trabajadorDAO;

	@Override
	@Transactional(readOnly=true)
	public List<Trabajador> findAll() {
		return trabajadorDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Trabajador> findById(Long id) {
		return trabajadorDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Trabajador trabajador) {
		trabajadorDAO.save(trabajador);
		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		trabajadorDAO.deleteById(id);
		
	}
	
	
	
}
