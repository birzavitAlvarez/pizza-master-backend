package com.proyecto.app.spring.service;

import com.proyecto.app.spring.DAO.ComprobantesDAO;
import com.proyecto.app.spring.entity.Comprobantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ComprobantesServiceImpl implements ComprobantesService{
    @Autowired
    private ComprobantesDAO comprobantesDAO;

    @Transactional(readOnly = true)
    @Override
    public List<Comprobantes> findAll() {
        return comprobantesDAO.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Comprobantes> findById(Long id) {
        return comprobantesDAO.findById(id);
    }

    @Transactional
    @Override
    public void save(Comprobantes comprobantes) {
       comprobantesDAO.save(comprobantes);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        comprobantesDAO.deleteById(id);
    }
}
