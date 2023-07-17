package com.proyecto.app.spring.DAO;

import com.proyecto.app.spring.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.app.spring.entity.Trabajador;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrabajadorDAO extends JpaRepository<Trabajador,Long> {
    public Optional<Trabajador> findByUsuario(Usuario usuario);
}
