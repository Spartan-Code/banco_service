/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.MovimientoBancario;
import com.fpmislata.banco.business.service.MovimientoBancarioService;
import com.fpmislata.banco.persistence.dao.MovimientoBancarioDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Equipo
 */
public class MovimientoBancarioServiceImpl extends GenericServiceImpl<MovimientoBancario> implements MovimientoBancarioService {

    @Autowired
    MovimientoBancarioDAO movimientoBancarioDAO;

    public MovimientoBancarioServiceImpl() {
    }
    
    @PostConstruct 
    public void asignarDAO() {
        this.genericDAO = movimientoBancarioDAO;
    }
    
    
    @Override
    public List<MovimientoBancario> findByNombre(String nombre) {
        return null;
    }
    
}
