package com.proyecto.app.spring.service;


import com.proyecto.app.spring.entity.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaService {
    public List<Venta> findAll();

    public Optional<Venta> findById(Long id);

    public Venta save(Venta venta);

    public void deleteById(Long id);
}
