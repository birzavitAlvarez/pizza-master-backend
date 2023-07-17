package com.proyecto.app.spring.DAO;

import com.proyecto.app.spring.entity.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleDAO extends JpaRepository<Detalle,Long> {
}
