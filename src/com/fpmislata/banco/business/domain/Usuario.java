/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import java.io.Serializable;



/**
 *
 * @author German
 */

public class Usuario implements Serializable {
    private int idUsuario;
    private String nombre,passwordEncrypt,email;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String passwordEncrypt, String email, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.passwordEncrypt = passwordEncrypt;
        this.email = email;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasswordEncrypt() {
        return passwordEncrypt;
    }

    public void setPasswordEncrypt(String passwordEncrypt) {
        this.passwordEncrypt = passwordEncrypt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
    
    
    
    
}
