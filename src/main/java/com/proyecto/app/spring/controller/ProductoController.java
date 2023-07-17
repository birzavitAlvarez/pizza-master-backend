package com.proyecto.app.spring.controller;

import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.app.spring.service.ProductoService;
import com.proyecto.app.spring.DTO.ProductoDTO;
import com.proyecto.app.spring.entity.*;

import java.math.BigDecimal;
import java.util.*;
@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	@Autowired
	private ModelMapper modelMapper; //productos faltantes
	@GetMapping
	public ResponseEntity <?> readAll(){
		List<Producto> productos=productoService.findAll();
		List<ProductoDTO> productosDTO=new ArrayList<>();
		for(Producto producto: productos) {
			ProductoDTO productoDTO=new ProductoDTO(producto.getId(),producto.getNombre(),producto.getUnidadMedida()
					,producto.getCantidadProducto(),producto.getClaseProducto(),producto.getProveedor().getId(),
					producto.getProveedor().getNombreP(),producto.getTrabajador().getId(),producto.getTrabajador().getNombre());
			productosDTO.add(productoDTO);
		}
		Collections.sort(productosDTO, Comparator.comparing(ProductoDTO::getNombre));
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        respuesta.put("data", productosDTO);
        return ResponseEntity.ok().body(respuesta);
		
	}
	@GetMapping("/faltantes")
	public ResponseEntity<?>faltantes(){
		List<Producto> productos=productoService.findAll().stream()
				.filter(p -> p.getCantidadProducto().compareTo(BigDecimal.TEN) <= 0).toList();
		List<ProductoDTO>productosDTO=productos.stream().map(producto->modelMapper.map(producto,ProductoDTO.class)).toList();
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("status", 200);
		respuesta.put("data", productosDTO);
		return ResponseEntity.ok().body(respuesta);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<Producto> productoOptional=productoService.findById(id);
		if(!productoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		ProductoDTO productoDTO=new ProductoDTO(productoOptional.get().getId(),productoOptional.get().getNombre(),
				productoOptional.get().getUnidadMedida(),productoOptional.get().getCantidadProducto(),
				productoOptional.get().getClaseProducto(),productoOptional.get().getProveedor().getId(),productoOptional.get().getProveedor().getNombreP(),
				productoOptional.get().getTrabajador().getId(),productoOptional.get().getTrabajador().getNombre());
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        respuesta.put("data", productoDTO);
		return ResponseEntity.ok().body(respuesta);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto){
		productoService.save(producto);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Producto producto,@PathVariable Long id){
		Optional<Producto> productoOptional= productoService.findById(id);
		if(!productoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		producto.setId(id);
		productoService.save(producto);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Producto> productoOptional= productoService.findById(id);
		if(!productoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoService.deleteById(id);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);
		
	}
	@PutMapping("/cantidad/{id}")
	public ResponseEntity<?> update(@RequestBody ProductoDTO productoDTO, @PathVariable Long id){
		Optional<Producto> productoOptional= productoService.findById(id);
		if(!productoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoOptional.get().setCantidadProducto(productoOptional.get().getCantidadProducto().add(productoDTO.getCantidadProducto()));
		productoService.save(productoOptional.get());
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("status", 200);
		return ResponseEntity.ok().body(respuesta);

	}
}
