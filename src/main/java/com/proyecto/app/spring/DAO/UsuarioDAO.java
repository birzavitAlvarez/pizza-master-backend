package com.proyecto.app.spring.DAO;
import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.proyecto.app.spring.entity.*;
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario,Long> {
	public Optional<Usuario> findByUsuario(String usuario);

	@Query("SELECT u FROM Usuario u LEFT JOIN Trabajador t ON u.id = t.usuario.id WHERE u.rol.id = 2 AND t IS NULL")
	List<Usuario> obtenerUsuariosTrabajadoresNoRegistrados();
}
