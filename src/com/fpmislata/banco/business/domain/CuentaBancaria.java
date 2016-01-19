/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Equipo
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CuentaBancaria implements Serializable{
    
    private int idCuentaBancaria;
    @NotBlank
    @Pattern(regexp="[0-9]{10}")
    private String numeroCuenta;
    private BigDecimal saldo;
    private Date fechaCreacion;
    @NotNull
    private SucursalBancaria sucursalBancaria;
    @NotNull
    private Usuario usuario;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int idCuentaBancaria, String numeroCuenta, BigDecimal saldo, Date fechaCreacion, SucursalBancaria sucursalBancaria, Usuario usuario) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.sucursalBancaria = sucursalBancaria;
        this.usuario = usuario;
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
