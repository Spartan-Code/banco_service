/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.util;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.core.BusinessMessage;
import com.fpmislata.banco.persistence.dao.CuentaBancariaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author German
 */
public class ValidadorCCC {

    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;

    public ValidadorCCC() {
    }

    public List<BusinessMessage> validarCCC(String ccc, CuentaBancaria cuentaBancaria) {
        List<BusinessMessage> businessMessages = new ArrayList<>();

        if (cuentaBancaria == null) {
            businessMessages.add(new BusinessMessage("El numero de cuenta origen no existe", "CCC"));
        } else {
            String cccCuentaBaseDatos = cuentaBancaria.getSucursalBancaria().getEntidadBancaria().getCodigoEntidad()
                    + cuentaBancaria.getSucursalBancaria().getCodigoSucursal()
                    + cuentaBancaria.getDigitoControl()
                    + cuentaBancaria.getNumeroCuenta();
            if (!(cccCuentaBaseDatos.equals(ccc))) {
                businessMessages.add(new BusinessMessage("CCC  incorrecto", "CCC"));
            }
        }

        return businessMessages;
    }

}
