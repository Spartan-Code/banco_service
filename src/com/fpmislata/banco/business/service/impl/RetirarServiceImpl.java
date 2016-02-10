/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.business.domain.Extraccion;
import com.fpmislata.banco.business.domain.MovimientoBancario;
import com.fpmislata.banco.business.domain.Tipo;
import com.fpmislata.banco.business.service.CuentaBancariaService;
import com.fpmislata.banco.business.service.MovimientoBancarioService;
import com.fpmislata.banco.business.service.RetirarService;
import com.fpmislata.banco.core.BusinessException;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author German
 */
public class RetirarServiceImpl implements RetirarService {

    @Autowired
    CuentaBancariaService cuentaBancariaService;

    @Autowired
    MovimientoBancarioService movimientoBancarioService;

    @Override
    public void insert(Extraccion extraccion) throws BusinessException {

        CuentaBancaria cuentaBancariaOrigen = cuentaBancariaService.findByCCC(extraccion.getCodigoCuentaCliente());

        this.insertMovimientoDebe(extraccion.getConcepto(), extraccion.getImporte(), cuentaBancariaOrigen);

    }

    @Override
    public void insertMovimientoDebe(String concepto, BigDecimal importe, CuentaBancaria cuentaBancaria) throws BusinessException {
        MovimientoBancario movimientoBancarioCuentaOrigen = new MovimientoBancario();
        movimientoBancarioCuentaOrigen.setFecha(new Date());
        movimientoBancarioCuentaOrigen.setConcepto(concepto);
        movimientoBancarioCuentaOrigen.setTipo(Tipo.Debe);
        movimientoBancarioCuentaOrigen.setImporte(importe);
        movimientoBancarioCuentaOrigen.setCuentaBancaria(cuentaBancaria);
        movimientoBancarioService.insert(movimientoBancarioCuentaOrigen);
    }

}
