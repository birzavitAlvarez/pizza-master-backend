package com.proyecto.app.spring.controller;

import com.proyecto.app.spring.DTO.DetalleDTO;
import com.proyecto.app.spring.entity.Detalle;
import com.proyecto.app.spring.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/detalle")
public class DetalleController {
    @Autowired
    private DetalleService detalleService;

    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Detalle> detalles=detalleService.findAll();
        List<DetalleDTO> detalleDTOS=new ArrayList<>();
        for (Detalle detalle:detalles){
            DetalleDTO detalleDTO=new DetalleDTO(detalle.getId(),detalle.getCarta().getIdCarta(),detalle.getCarta().getNombreCarta(),
                    detalle.getCarta().getPrecioCarta(),detalle.getVenta().getId(),detalle.getCantidad(),detalle.getPrecio(),
                    detalle.getTotal());
            detalleDTOS.add(detalleDTO);
        }
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",detalleDTOS);
        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable Long id){
        Optional<Detalle> detalleOptional=detalleService.findById(id);
        if(!detalleOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        DetalleDTO detalleDTO=new DetalleDTO(detalleOptional.get().getId(),detalleOptional.get().getCarta().getIdCarta(),detalleOptional.get().getCarta().getNombreCarta(),
                detalleOptional.get().getCarta().getPrecioCarta(),detalleOptional.get().getVenta().getId(),detalleOptional.get().getCantidad(),detalleOptional.get().getPrecio(),
                detalleOptional.get().getTotal());

        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",detalleDTO);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody List<Detalle> detalles){
        for (Detalle detalle:detalles){
            detalleService.save(detalle);
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Detalle detalle){
        Optional<Detalle> detalleOptional=detalleService.findById(id);
        if(!detalleOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        detalle.setId(id);
        detalleService.save(detalle);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Detalle> detalleOptional=detalleService.findById(id);
        if(!detalleOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        detalleService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
}
