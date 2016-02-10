/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import java.io.Serializable;

/**
 *
 * @author Equipo
 */
public class CredencialesBancarias implements Serializable {
    
    private String url;
    
    private String pin;

    public CredencialesBancarias() {
    }

    public CredencialesBancarias(String url, String pin) {
        this.url = url;
        this.pin = pin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    
    
}
