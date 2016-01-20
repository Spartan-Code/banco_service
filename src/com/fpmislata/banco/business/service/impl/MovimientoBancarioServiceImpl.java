/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.business.domain.MovimientoBancario;
import com.fpmislata.banco.business.domain.Tipo;
import com.fpmislata.banco.business.service.MovimientoBancarioService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.CuentaBancariaDAO;
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

    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;
    
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

    @Override
    public List<MovimientoBancario> findByidCuentaBancaria(int idCuentaBancaria) {
        return movimientoBancarioDAO.findByidCuentaBancaria(idCuentaBancaria);
    }
    
    
    @Override
    public MovimientoBancario insert(MovimientoBancario movimientoBancario) throws BusinessException {
        
        
        if(movimientoBancario.getImporte()==null){
            throw new BusinessException("El campo Importe tiene contenido no valido","Importe");
        }else{
        CuentaBancaria cuentaBancaria= cuentaBancariaDAO.get(movimientoBancario.getCuentaBancaria().getIdCuentaBancaria());
        
        if(movimientoBancario.getTipo() == Tipo.Debe){
            cuentaBancaria.setSaldo(cuentaBancaria.getSaldo().subtract(movimientoBancario.getImporte()));
        }else{
            cuentaBancaria.setSaldo(cuentaBancaria.getSaldo().add(movimientoBancario.getImporte()));
        }
        movimientoBancario.setSaldo(cuentaBancaria.getSaldo());
        cuentaBancariaDAO.update(cuentaBancaria);
        
        return genericDAO.insert(movimientoBancario);
        }
    }
    
}
