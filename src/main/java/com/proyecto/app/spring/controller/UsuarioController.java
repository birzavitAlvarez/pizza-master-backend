package com.proyecto.app.spring.controller;

import com.proyecto.app.spring.DAO.TrabajadorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.proyecto.app.spring.DTO.UsuarioDTO;
import com.proyecto.app.spring.entity.*;
import com.proyecto.app.spring.service.UsuarioService;
@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TrabajadorDAO trabajadorDAO;
	@GetMapping("/trabajadores")
	public ResponseEntity<?> readUsuarioTrabajador(){
			List<Usuario> usuarios=usuarioService.obtenerUsuariosTrabajadoresNoRegistrados();
			List<UsuarioDTO>usuariosDTO=new ArrayList<>();
			for(Usuario usuario:usuarios) {
				UsuarioDTO usuarioDTO=new UsuarioDTO(usuario.getId(),usuario.getRol().getId(),
						usuario.getRol().getNombreRol(),usuario.getUsuario(),usuario.getContrasena());
				usuariosDTO.add(usuarioDTO);
			}
			Map<String, Object> respuesta = new HashMap<>();
			respuesta.put("status", 200);
			respuesta.put("data", usuariosDTO);
			return ResponseEntity.ok(respuesta);

	}
	@GetMapping
	public ResponseEntity<?> readAll(){
		List<Usuario> usuarios=usuarioService.findAll();
		List<UsuarioDTO>usuariosDTO=new ArrayList<>();
		for(Usuario usuario:usuarios) {
			UsuarioDTO usuarioDTO=new UsuarioDTO(usuario.getId(),usuario.getRol().getId(),
					usuario.getRol().getNombreRol(),usuario.getUsuario(),usuario.getContrasena());
			usuariosDTO.add(usuarioDTO);
		}
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        respuesta.put("data", usuariosDTO);
        return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> readById(@PathVariable Long id){
		Optional<Usuario> usuarioOptional=usuarioService.findById(id);
		if(!usuarioOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		UsuarioDTO usuarioDTO=new UsuarioDTO(usuarioOptional.get().getId(),usuarioOptional.get().getRol().getId(),
				usuarioOptional.get().getRol().getNombreRol(),
				usuarioOptional.get().getUsuario(),usuarioOptional.get().getContrasena());
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        respuesta.put("data", usuarioDTO);
        return ResponseEntity.ok(respuesta);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		usuarioService.save(usuario);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
	}
	@PostMapping("/login")
	public ResponseEntity<?> validation(@RequestBody UsuarioDTO usuarioDTO){
		if(usuarioService.validarUsuario(usuarioDTO.getUsuario(), usuarioDTO.getContrasena())) {
			Optional<Trabajador> trabajador=trabajadorDAO.findByUsuario(usuarioService.findByUsuario(usuarioDTO.getUsuario()).get());
			if(trabajador.isPresent()){
				UsuarioDTO usuario=new UsuarioDTO(usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getId(),
						usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getRol().getId(),
						usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getRol().getNombreRol(),
						usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getUsuario(),
						usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getContrasena(),
						trabajador.get().getId());
				Map<String, Object> respuesta = new HashMap<>();
				respuesta.put("status", 200);
				respuesta.put("data", usuario);
				return ResponseEntity.ok(respuesta);
			}
			UsuarioDTO usuario=new UsuarioDTO(usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getId(),
					usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getRol().getId(),
					usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getRol().getNombreRol(),
					usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getUsuario(),
					usuarioService.findByUsuario(usuarioDTO.getUsuario()).get().getContrasena(),
                    usuarioDTO.getIdTrabajador());
			Map<String, Object> respuesta = new HashMap<>();
	        respuesta.put("status", 200);
	        respuesta.put("data", usuario);
	        return ResponseEntity.ok(respuesta);
		}
		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuario ,@PathVariable Long id){
		Optional<Usuario> usuarioOptional=usuarioService.findById(id);
		if(!usuarioOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuario.setId(id);
		usuarioService.save(usuario);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
	}
	@PutMapping("/rol/{id}")
	public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody Roles rol){
		Optional<Usuario> usuarioOptional=usuarioService.findById(id);
		if(!usuarioOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioOptional.get().setRol(rol);
		usuarioService.save(usuarioOptional.get());
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Usuario> usuarioOptional=usuarioService.findById(id);
		if(!usuarioOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.deleteById(id);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
	}
	
	
	
}
