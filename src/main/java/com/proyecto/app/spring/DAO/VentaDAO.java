package com.proyecto.app.spring.DAO;

import com.proyecto.app.spring.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaDAO extends JpaRepository<Venta,Long> {
}
