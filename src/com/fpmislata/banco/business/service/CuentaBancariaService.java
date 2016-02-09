/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.business.domain.Pago;
import com.fpmislata.banco.business.domain.Tipo;
import com.fpmislata.banco.business.domain.Transaccion;
import com.fpmislata.banco.core.BusinessException;
import java.util.List;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public interface CuentaBancariaService extends GenericService<CuentaBancaria> {

    List<CuentaBancaria> findByNombre(String nombre);

    CuentaBancaria findByNumeroCuenta(String numeroCuenta)throws BusinessException;

    void doTransaccion(Transaccion transaccion) throws BusinessException;
    
    void retirarDinero(Pago pago,Tipo tipo)throws BusinessException;
}
