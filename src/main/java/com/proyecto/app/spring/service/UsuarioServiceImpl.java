package com.proyecto.app.spring.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.proyecto.app.spring.DAO.UsuarioDAO;
import com.proyecto.app.spring.entity.Usuario;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<Usuario> obtenerUsuariosTrabajadoresNoRegistrados() {

		return usuarioDAO.obtenerUsuariosTrabajadoresNoRegistrados();
    }

    @Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return usuarioDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Usuario> findByUsuario(String usuario) {
		return usuarioDAO.findByUsuario(usuario);
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDAO.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		usuarioDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Usuario> findById(Long id) {
		return usuarioDAO.findById(id);
				
	}
	@Override
	@Transactional(readOnly=true)
	public boolean validarUsuario(String usuario, String contrasena) {
		if(usuarioDAO.findByUsuario(usuario).isPresent()) {
			if(usuarioDAO.findByUsuario(usuario).get().getContrasena().equals(contrasena)) {
				return true;
			}
			return false;	
		}
		return false;
	}

}
