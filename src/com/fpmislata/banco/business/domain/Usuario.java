/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;



/**
 *
 * @author German
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario implements Serializable {
    
     
    private int idUsuario;
     
    
    @NotBlank
    @Size(min = 5, max = 20)
    private String nickName;
    
    
    private String nif;
    
    private String nombre;
    
    private String passwordEncrypt;
       
    @NotBlank
    @Email
    @Size(min = 20, max = 50)
    private String email;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nickName, String nif, String nombre, String passwordEncrypt, String email, Rol rol) {
        this.idUsuario = idUsuario;
        this.nickName = nickName;
        this.nif = nif;
        this.nombre = nombre;
        this.passwordEncrypt = passwordEncrypt;
        this.email = email;
        this.rol = rol;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
   

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
