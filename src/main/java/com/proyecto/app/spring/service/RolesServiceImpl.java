package com.proyecto.app.spring.service;

import com.proyecto.app.spring.DAO.RolesDAO;
import com.proyecto.app.spring.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolesServiceImpl implements RolesService{
    @Autowired
    private RolesDAO rolesDAO;
    @Override
    public List<Roles> findAll() {
        return rolesDAO.findAll();
    }
}
