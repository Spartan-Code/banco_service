/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Equipo
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pago implements Serializable {

    private String codigoCuentaCliente;

    private String codigoEntidadBancaria;

    private String pin;

    private BigDecimal importe;

    private String concepto;

    public Pago() {
    }

    public Pago(String codigoCuentaCliente, String codigoEntidadBancaria, String pin, BigDecimal importe, String concepto) {
        this.codigoCuentaCliente = codigoCuentaCliente;
        this.codigoEntidadBancaria = codigoEntidadBancaria;
        this.pin = pin;
        this.importe = importe;
        this.concepto = concepto;
    }

    public String getCodigoCuentaCliente() {
        return codigoCuentaCliente;
    }

    public void setCodigoCuentaCliente(String codigoCuentaCliente) {
        this.codigoCuentaCliente = codigoCuentaCliente;
    }

    public String getCodigoEntidadBancaria() {
        return codigoEntidadBancaria;
    }

    public void setCodigoEntidadBancaria(String codigoEntidadBancaria) {
        this.codigoEntidadBancaria = codigoEntidadBancaria;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    
    

}
