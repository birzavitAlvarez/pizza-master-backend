package com.proyecto.app.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.proyecto.app.spring.service.TrabajadorService;
import com.proyecto.app.spring.entity.*;
import com.proyecto.app.spring.DTO.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/trabajador")
public class TrabajadorController {
	@Autowired
	private TrabajadorService trabajadorService;
	
	@GetMapping
	public ResponseEntity<?> readAll(){
		List<Trabajador> trabajadores =trabajadorService.findAll();
		List<TrabajadorDTO> trabajadoresDTO=new ArrayList<>();
		for(Trabajador trabajador: trabajadores) {
			TrabajadorDTO trabajadorDTO=new TrabajadorDTO(trabajador.getId(),trabajador.getNombre(),trabajador.getApellido(),
					trabajador.getEdad(),trabajador.getDni(),trabajador.getTelefono(),trabajador.getCorreo(),trabajador.getFechaAlta(),
					trabajador.getFechaBaja(),trabajador.getDireccion(),trabajador.getUsuario().getUsuario(),trabajador.getUsuario().getId());
			trabajadoresDTO.add(trabajadorDTO);
		}
		Map<String,Object> respuesta=new HashMap<>();
		respuesta.put("status",200);
		respuesta.put("data", trabajadoresDTO);
		return ResponseEntity.ok(respuesta);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Trabajador> trabajadorOptional=trabajadorService.findById(id);
		if(!trabajadorOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		TrabajadorDTO trabajadorDTO=new TrabajadorDTO(trabajadorOptional.get().getId(),trabajadorOptional.get().getNombre()
				,trabajadorOptional.get().getApellido(),trabajadorOptional.get().getEdad(),trabajadorOptional.get().getDni(),trabajadorOptional.get().getTelefono()
				,trabajadorOptional.get().getCorreo(),trabajadorOptional.get().getFechaAlta(),trabajadorOptional.get().getFechaBaja(),
				trabajadorOptional.get().getDireccion(),trabajadorOptional.get().getUsuario().getUsuario(),trabajadorOptional.get().getUsuario().getId());
		Map<String,Object> respuesta=new HashMap<>();
		respuesta.put("status",200);
		respuesta.put("data", trabajadorDTO);
		return ResponseEntity.ok(respuesta);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Trabajador trabajador){
		trabajadorService.save(trabajador);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok(respuesta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Trabajador trabajador,@PathVariable Long id){
		Optional<Trabajador> trabajadorOptional= trabajadorService.findById(id);
		if(!trabajadorOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		trabajador.setId(id);
		trabajadorService.save(trabajador);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok(respuesta);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Trabajador> trabajadorOptional= trabajadorService.findById(id);
		if(!trabajadorOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		trabajadorService.deleteById(id);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok(respuesta);
		
	}
	
	
	
	
	
	
	
}
