package com.proyecto.app.spring.DAO;

import com.proyecto.app.spring.entity.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteDAO extends JpaRepository<Ingrediente,Long> {
}
