package com.proyecto.app.spring.DAO;

import com.proyecto.app.spring.entity.Comprobantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobantesDAO extends JpaRepository<Comprobantes,Long>{
}
