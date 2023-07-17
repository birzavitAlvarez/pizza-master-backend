package com.proyecto.app.spring.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.app.spring.entity.Proveedor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProveedorDAO extends JpaRepository<Proveedor,Long>{
	public List<Proveedor> findByNombrePContaining(String nombreP);
	public List<Proveedor> findAll();
}
