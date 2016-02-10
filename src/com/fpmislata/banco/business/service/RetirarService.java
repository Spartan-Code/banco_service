/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.business.domain.Extraccion;
import com.fpmislata.banco.core.BusinessException;
import java.math.BigDecimal;

/**
 *
 * @author German
 */
public interface RetirarService {
    
    
    void insert(Extraccion pago)throws BusinessException;
    
    void insertMovimientoDebe(String concepto, BigDecimal importe , CuentaBancaria cuentaBancaria)throws BusinessException;
}
