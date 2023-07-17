package com.proyecto.app.spring.service;

import com.proyecto.app.spring.DAO.VentaDAO;
import com.proyecto.app.spring.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
    private VentaDAO ventaDAO;
    @Override
    public List<Venta> findAll() {
        return ventaDAO.findAll();
    }

    @Override
    public Optional<Venta> findById(Long id) {
        return ventaDAO.findById(id);
    }

    @Override
    public Venta save(Venta venta) {
        return ventaDAO.save(venta);
    }

    @Override
    public void deleteById(Long id) {
        ventaDAO.deleteById(id);
    }
}
