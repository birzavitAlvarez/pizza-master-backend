package com.proyecto.app.spring.controller;
import com.proyecto.app.spring.DTO.ComprobantesDTO;
import com.proyecto.app.spring.entity.Comprobantes;
import com.proyecto.app.spring.service.ComprobantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/comprobante")
public class ComprobantesController {
    @Autowired
    private ComprobantesService comprobantesService;

    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Comprobantes> comprobantes=comprobantesService.findAll();
        List<ComprobantesDTO> comprobantesDTO=new ArrayList<>();
        for (Comprobantes comprobante:comprobantes){
            ComprobantesDTO comprobanteDTO=new ComprobantesDTO(comprobante.getId(),comprobante.getProducto().getNombre()
            ,comprobante.getProducto().getId(),comprobante.getFechaCompro(),comprobante.getTotalCompro());
            comprobantesDTO.add(comprobanteDTO);
        }
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",comprobantesDTO);
        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable Long id){
        Optional<Comprobantes> comprobanteOptional=comprobantesService.findById(id);
        if(!comprobanteOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        ComprobantesDTO comprobanteDTO=new ComprobantesDTO(comprobanteOptional.get().getId(),comprobanteOptional.get().getProducto()
                .getNombre(),comprobanteOptional.get().getProducto().getId(),comprobanteOptional.get().getFechaCompro(),
                comprobanteOptional.get().getTotalCompro());

        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",comprobanteDTO);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Comprobantes comprobante){
        comprobantesService.save(comprobante);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Comprobantes comprobante){
        Optional<Comprobantes> comprobanteOptional=comprobantesService.findById(id);
        if(!comprobanteOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        comprobante.setId(id);
        comprobantesService.save(comprobante);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Comprobantes> comprobanteOptional=comprobantesService.findById(id);
        if(!comprobanteOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        comprobantesService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }

}
