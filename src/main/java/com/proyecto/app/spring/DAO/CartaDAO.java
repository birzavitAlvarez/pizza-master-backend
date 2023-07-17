package com.proyecto.app.spring.DAO;

import com.proyecto.app.spring.entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaDAO extends JpaRepository<Carta,Long> {
}
