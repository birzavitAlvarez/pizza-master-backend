package com.proyecto.app.spring.service;
import java.util.*;
import com.proyecto.app.spring.entity.*;
public interface UsuarioService {

	public List<Usuario> obtenerUsuariosTrabajadoresNoRegistrados();
	public List<Usuario> findAll();
	public boolean validarUsuario(String usuario, String contrasena);
	public Optional<Usuario> findByUsuario(String usuario);
	public void save(Usuario usuario);
	public void deleteById(Long id);
	public Optional<Usuario> findById(Long id);
}
