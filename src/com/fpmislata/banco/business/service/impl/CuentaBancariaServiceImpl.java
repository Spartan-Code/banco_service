/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.business.service.CuentaBancariaService;
import com.fpmislata.banco.persistence.dao.CuentaBancariaDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Equipo
 */
public class CuentaBancariaServiceImpl extends GenericServiceImpl<CuentaBancaria> implements CuentaBancariaService {
    
    
    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;

    public CuentaBancariaServiceImpl() {
    }
    
    @PostConstruct 
    public void asignarDAO() {
        this.genericDAO = cuentaBancariaDAO;
    }
    
    
    
    
    @Override
    public List<CuentaBancaria> findByNombre(String nombre) {
        return null;
    }
    
}
