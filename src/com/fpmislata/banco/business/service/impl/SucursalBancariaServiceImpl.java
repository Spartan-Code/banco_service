/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.business.service.SucursalBancariaService;
import com.fpmislata.banco.persistence.dao.SucursalBancariaDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Equipo
 */
public class SucursalBancariaServiceImpl extends GenericServiceImpl<SucursalBancaria> implements SucursalBancariaService {
    
    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;

    public SucursalBancariaServiceImpl() {
    }

   
    
    @PostConstruct 
    public void asignarDAO() {
        this.genericDAO = sucursalBancariaDAO;
    }

    @Override
    public List<SucursalBancaria> findByNombre(String nombre) {
        return null;
    }
}
