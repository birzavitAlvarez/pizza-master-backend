package com.proyecto.app.spring.service;

import com.proyecto.app.spring.DAO.DetalleDAO;
import com.proyecto.app.spring.entity.Detalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServiceImpl implements DetalleService{

    @Autowired
    private DetalleDAO detalleDAO;
    @Override
    public List<Detalle> findAll() {
        return detalleDAO.findAll();
    }

    @Override
    public Optional<Detalle> findById(Long id) {
        return detalleDAO.findById(id);
    }

    @Override
    public void save(Detalle detalle) {
        detalleDAO.save(detalle);
    }

    @Override
    public void deleteById(Long id) {
        detalleDAO.deleteById(id);
    }
}
