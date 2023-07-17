package com.proyecto.app.spring.controller;

import com.proyecto.app.spring.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/rol")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping
    public ResponseEntity<?> read(){
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("status",200);
        respuesta.put("data",rolesService.findAll());
        return ResponseEntity.ok(respuesta);
    }
}
