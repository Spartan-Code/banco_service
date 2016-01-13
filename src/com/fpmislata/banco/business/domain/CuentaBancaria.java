/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Equipo
 */
public class CuentaBancaria implements Serializable{
    
    private int idCuentaBancaria;
    private String numeroCuenta;
    private float saldo;
    private Date fechaCreacion;
    private SucursalBancaria sucursalBancaria;
    private Usuario usuario;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int idCuentaBancaria, String numeroCuenta, float saldo, Date fechaCreacion, SucursalBancaria sucursalBancaria, Usuario usuario) {
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

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
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
