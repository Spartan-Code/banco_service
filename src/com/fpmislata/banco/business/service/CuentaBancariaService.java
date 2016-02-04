/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.CuentaBancaria;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public interface CuentaBancariaService extends GenericService<CuentaBancaria> {

    CuentaBancaria findByNumeroCuenta(String numeroCuenta);
}
