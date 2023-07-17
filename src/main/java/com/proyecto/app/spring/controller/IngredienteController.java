package com.proyecto.app.spring.controller;
import com.proyecto.app.spring.DTO.IngredienteDTO;
import com.proyecto.app.spring.entity.Ingrediente;
import com.proyecto.app.spring.entity.Producto;
import com.proyecto.app.spring.service.IngredienteService;
import com.proyecto.app.spring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {
    @Autowired
    private IngredienteService ingredienteService;
    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Ingrediente> ingredientes=ingredienteService.findAll();
        List<IngredienteDTO> ingredientesDTO=new ArrayList<>();
        for (Ingrediente ingrediente:ingredientes){
            IngredienteDTO ingredienteDTO=new IngredienteDTO(ingrediente.getId(),ingrediente.getNombreProducto(),ingrediente.getCantidadProducto(),
                    ingrediente.getCarta().getIdCarta(),ingrediente.getCarta().getNombreCarta());
            ingredientesDTO.add(ingredienteDTO);
        }
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",ingredientesDTO);
        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable Long id){
        Optional<Ingrediente> ingredienteOptional=ingredienteService.findById(id);
        if(!ingredienteOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        IngredienteDTO ingredienteDTO=new IngredienteDTO(ingredienteOptional.get().getId(),ingredienteOptional.get().getNombreProducto(),ingredienteOptional.get().getCantidadProducto(),ingredienteOptional.get().getCarta().getIdCarta(),
                ingredienteOptional.get().getCarta().getNombreCarta());

        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",ingredienteDTO);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Ingrediente ingrediente){
        ingredienteService.save(ingrediente);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Ingrediente ingrediente){
        Optional<Ingrediente> ingredienteOptional=ingredienteService.findById(id);
        if(!ingredienteOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        ingrediente.setId(id);
        ingredienteService.save(ingrediente);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Ingrediente> ingredienteOptional=ingredienteService.findById(id);
        if(!ingredienteOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        ingredienteService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
}
