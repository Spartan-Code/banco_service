/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.CredencialesBancarias;
import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.business.domain.MovimientoBancario;
import com.fpmislata.banco.business.domain.Tipo;
import com.fpmislata.banco.business.domain.Transaccion;
import com.fpmislata.banco.business.service.BancoCentralService;
import com.fpmislata.banco.business.service.CuentaBancariaService;
import com.fpmislata.banco.business.service.MovimientoBancarioService;
import com.fpmislata.banco.business.service.PeticionRetirarDineroService;
import com.fpmislata.banco.business.service.TransaccionService;
import com.fpmislata.banco.core.BusinessException;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author German
 */
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    CuentaBancariaService cuentaBancariaService;

    @Autowired
    MovimientoBancarioService movimientoBancarioService;

    @Autowired
    BancoCentralService bancoCentralService;

    @Autowired
    PeticionRetirarDineroService peticionRetirarDineroService;

    @Override
    public void insert(Transaccion transaccion) throws BusinessException {

        CuentaBancaria cuentaBancariaDestino = cuentaBancariaService.findByCCC(transaccion.getCuentaDestino());

        CredencialesBancarias credencialesBancarias = bancoCentralService.getURLbyCCC(transaccion.getCuentaOrigen());

        peticionRetirarDineroService.sendPeticionBancaria(credencialesBancarias, transaccion.getCuentaOrigen(), transaccion.getConcepto(), transaccion.getImporte(), transaccion.getCuentaDestino().substring(0, 4));

        if (transaccion.getPin() == null) {
            throw new BusinessException("No se ha especificado un pin", "pin");
        }
        if (!(transaccion.getPin().equals(cuentaBancariaDestino.getPin()))) {
            throw new BusinessException("Pin de la cuenta destino incorrecto", "pin");
        }

        this.insertMovimientoHaber(transaccion.getConcepto(), transaccion.getImporte(), cuentaBancariaDestino);

    }

    @Override
    public void insertMovimientoHaber(String concepto, BigDecimal importe, CuentaBancaria cuentaBancaria) throws BusinessException {

        MovimientoBancario movimientoBancarioCuentaDestino = new MovimientoBancario();
        movimientoBancarioCuentaDestino.setFecha(new Date());
        movimientoBancarioCuentaDestino.setConcepto(concepto);
        movimientoBancarioCuentaDestino.setTipo(Tipo.Haber);
        movimientoBancarioCuentaDestino.setImporte(importe);
        movimientoBancarioCuentaDestino.setCuentaBancaria(cuentaBancaria);
        movimientoBancarioService.insert(movimientoBancarioCuentaDestino);

    }

}
