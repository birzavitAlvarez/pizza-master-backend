package com.proyecto.app.spring.controller;

import com.proyecto.app.spring.DTO.CartaDTO;
import com.proyecto.app.spring.entity.Carta;
import com.proyecto.app.spring.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/carta")
public class CartaController {
    @Autowired
    private CartaService cartaService;

    @GetMapping
    public ResponseEntity<?> readAll(){
        List<Carta> cartas=cartaService.findAll();
        List<CartaDTO> cartasDTO=new ArrayList<>();
        for (Carta carta:cartas){
            CartaDTO cartaDTO=new CartaDTO(carta.getIdCarta(),carta.getNombreCarta(),carta.getImagenCarta(),
                    carta.getDescripcionCarta(),carta.getPrecioCarta(),carta.getIngredientes(),carta.getDetalles());
            cartasDTO.add(cartaDTO);
        }
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",cartasDTO);
        return ResponseEntity.ok(respuesta);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable Long id){
        Optional<Carta> cartaOptional=cartaService.findById(id);
        if(!cartaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        CartaDTO cartaDTO=new CartaDTO(cartaOptional.get().getIdCarta(),cartaOptional.get().getNombreCarta()
                ,cartaOptional.get().getImagenCarta(),cartaOptional.get().getDescripcionCarta(),cartaOptional.get().getPrecioCarta()
                ,cartaOptional.get().getIngredientes(),cartaOptional.get().getDetalles());

        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",cartaDTO);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Carta carta){
        cartaService.save(carta);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        respuesta.put("data",carta);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Carta carta){
        Optional<Carta> cartaOptional=cartaService.findById(id);
        if(!cartaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        carta.setIdCarta(id);
        cartaService.save(carta);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Carta> cartaOptional=cartaService.findById(id);
        if(!cartaOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        cartaService.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
        return ResponseEntity.ok(respuesta);
    }
}
