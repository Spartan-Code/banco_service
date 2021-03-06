/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.core.BusinessException;
import java.util.List;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public interface CuentaBancariaService extends GenericService<CuentaBancaria> {

    List<CuentaBancaria> findByNombre(String nombre);

    CuentaBancaria findByCCC(String numeroCuenta) throws BusinessException;

    
}
