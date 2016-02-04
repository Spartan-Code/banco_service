/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.business.service.CuentaBancariaService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.CuentaBancariaDAO;
import com.fpmislata.banco.persistence.dao.SucursalBancariaDAO;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Equipo
 */
public class CuentaBancariaServiceImpl extends GenericServiceImpl<CuentaBancaria> implements CuentaBancariaService {

    @Autowired
    CuentaBancariaDAO cuentaBancariaDAO;

    @Autowired
    SucursalBancariaDAO sucursalBancariaDAO;

    public CuentaBancariaServiceImpl() {
    }

    @PostConstruct
    public void asignarDAO() {
        this.genericDAO = cuentaBancariaDAO;
    }

    @Override
    public CuentaBancaria findByNumeroCuenta(String numeroCuenta) {
        return cuentaBancariaDAO.findByNumeroCuenta(numeroCuenta);
    }

    @Override
    public List<CuentaBancaria> findByNombre(String nombre) {
        return null;
    }

    @Override
    public CuentaBancaria insert(CuentaBancaria cuentaBancaria) throws BusinessException {
        if (cuentaBancaria.getNumeroCuenta() == null) {
            throw new BusinessException("El numero de cuenta no puede estar vacio", "numeroCuenta");
        }
        Pattern patternCuentaEntidad = Pattern.compile("[0-9]{10}");
        Matcher matcher = patternCuentaEntidad.matcher(cuentaBancaria.getNumeroCuenta());
        if (!matcher.matches()) {
            throw new BusinessException("El numero de cuenta debe contener diez digitos", "numeroCuenta");
        } else {
            if (cuentaBancaria.getSucursalBancaria() == null) {
                throw new BusinessException("Debes seleccionar una sucursal bancaria", "sucursalBancaria");
            }
            SucursalBancaria sucursalBancaria = sucursalBancariaDAO.get(cuentaBancaria.getSucursalBancaria().getIdSucursalBancaria());

            String digitoControl = this.calcularDigitoControl(sucursalBancaria.getEntidadBancaria().getCodigoEntidad(), sucursalBancaria.getCodigoSucursal(), cuentaBancaria.getNumeroCuenta());
            cuentaBancaria.setDigitoControl(digitoControl);
            return cuentaBancariaDAO.insert(cuentaBancaria);
        }

    }

    public String calcularDigitoControl(String codigoEntidadBancaria, String codigoSucursalBancaria, String codigoCuentaBancaria) throws BusinessException {

        int dc1 = 0;

        dc1 = dc1 + Integer.parseInt(codigoEntidadBancaria.substring(0, 1)) * 4;
        dc1 = dc1 + Integer.parseInt(codigoEntidadBancaria.substring(1, 2)) * 8;
        dc1 = dc1 + Integer.parseInt(codigoEntidadBancaria.substring(2, 3)) * 5;
        dc1 = dc1 + Integer.parseInt(codigoEntidadBancaria.substring(3, 4)) * 10;
        dc1 = dc1 + Integer.parseInt(codigoSucursalBancaria.substring(0, 1)) * 9;
        dc1 = dc1 + Integer.parseInt(codigoSucursalBancaria.substring(1, 2)) * 7;
        dc1 = dc1 + Integer.parseInt(codigoSucursalBancaria.substring(2, 3)) * 3;
        dc1 = dc1 + Integer.parseInt(codigoSucursalBancaria.substring(3, 4)) * 6;

        dc1 = dc1 % 11;
        dc1 = 11 - dc1;
        if (dc1 == 10) {
            dc1 = 1;
        }
        if (dc1 == 11) {
            dc1 = 0;
        }

        int dc2 = 0;

        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(0, 1)) * 1;
        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(1, 2)) * 2;
        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(2, 3)) * 4;
        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(3, 4)) * 8;
        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(4, 5)) * 5;
        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(5, 6)) * 10;
        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(6, 7)) * 9;
        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(7, 8)) * 7;
        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(8, 9)) * 3;
        dc2 = dc2 + Integer.parseInt(codigoCuentaBancaria.substring(9, 10)) * 6;

        dc2 = dc2 % 11;
        dc2 = 11 - dc2;
        if (dc2 == 10) {
            dc2 = 1;
        }
        if (dc2 == 11) {
            dc2 = 0;
        }

        String dc = String.valueOf(dc1) + String.valueOf(dc2);

        return dc;

    }
}
