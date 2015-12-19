/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.business.service.UsuarioService;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Equipo
 */
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl() {
    }
    
    
    

    @PostConstruct 
    public void asignarDAO() {
        this.genericDAO = usuarioDAO;
    }
    
    
    
    
    @Override
    public List<Usuario> findByNombre(String nombre) {
        return null;
    }
    
}
