package com.proyecto.app.spring.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.app.spring.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDAO extends JpaRepository<Producto,Long>{
	
}
