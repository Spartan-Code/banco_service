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

/**
 *
 * @author Equipo
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MovimientoBancario implements Serializable {
    
    
    private int idMovimientoBancario;
    private Date fecha;
    private String concepto;
    private Tipo tipo;
    private BigDecimal saldo, importe;
    private CuentaBancaria cuentaBancaria;

    public MovimientoBancario() {
    }

    public MovimientoBancario(int idMovimientoBancario, Date fecha, String concepto, Tipo tipo, BigDecimal saldo, BigDecimal importe, CuentaBancaria cuentaBancaria) {
        this.idMovimientoBancario = idMovimientoBancario;
        this.fecha = fecha;
        this.concepto = concepto;
        this.tipo = tipo;
        this.saldo = saldo;
        this.importe = importe;
        this.cuentaBancaria = cuentaBancaria;
    }

    public int getIdMovimientoBancario() {
        return idMovimientoBancario;
    }

    public void setIdMovimientoBancario(int idMovimientoBancario) {
        this.idMovimientoBancario = idMovimientoBancario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    
    
    
    
    
}
