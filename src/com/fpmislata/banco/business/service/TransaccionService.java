/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;


import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.business.domain.Transaccion;
import com.fpmislata.banco.core.BusinessException;
import java.math.BigDecimal;

/**
 *
 * @author German
 */
public interface TransaccionService {
    
    void insert(Transaccion transaccion)throws BusinessException;
       
    void insertMovimientoHaber(String concepto, BigDecimal importe , CuentaBancaria cuentaBancaria)throws BusinessException;
    
}
