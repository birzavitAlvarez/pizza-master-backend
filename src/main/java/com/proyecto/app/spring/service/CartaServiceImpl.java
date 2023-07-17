package com.proyecto.app.spring.service;

import com.proyecto.app.spring.DAO.CartaDAO;
import com.proyecto.app.spring.entity.Carta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaServiceImpl implements CartaService{
    @Autowired
    private CartaDAO cartaDAO;
    @Override
    public List<Carta> findAll() {
        return cartaDAO.findAll() ;
    }

    @Override
    public Optional<Carta> findById(Long id) {
        return cartaDAO.findById(id);
    }

    @Override
    public void save(Carta carta) {
        cartaDAO.save(carta);
    }

    @Override
    public void deleteById(Long id) {
       cartaDAO.deleteById(id);
    }
}
