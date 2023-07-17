package com.proyecto.app.spring.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.app.spring.entity.Proveedor;
import com.proyecto.app.spring.service.ProveedorService;
@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {
	@Autowired
	private ProveedorService proveedorService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Proveedor proveedor){
		proveedorService.save(proveedor);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}
	
	@GetMapping
	public ResponseEntity<?> readAll(){
		List<Proveedor> proveedores=proveedorService.findAll();
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        respuesta.put("data", proveedores);
		return ResponseEntity.ok().body(respuesta);
	}
	@GetMapping("/{id}") 
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Proveedor> oproveedor=proveedorService.findById(id);
		if(!oproveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        respuesta.put("data", oproveedor.get());
		return ResponseEntity.ok().body(respuesta);
	}
	/*@GetMapping("/{nombreP}")
	public ResponseEntity<?> read(@PathVariable String nombreP) {
		List<Proveedor> proveedores=proveedorService.findByNombrePContaining(nombreP);
		return ResponseEntity.ok(proveedores);
	}*/
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Proveedor proveedorDetails,@PathVariable Long id){
		Optional<Proveedor> oproveedor=proveedorService.findById(id);
		if(!oproveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		proveedorDetails.setId(oproveedor.get().getId());
		proveedorService.save(proveedorDetails);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		if(!proveedorService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
	    proveedorService.deleteById(id);
	    Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}
}
