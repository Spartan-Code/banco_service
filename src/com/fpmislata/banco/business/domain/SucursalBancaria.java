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
 * @author German
 */
public class SucursalBancaria implements Serializable {

    private int idSucursalBancaria;
    private String nombre, codigoSucursal, direccion , poblacion, codigoPostal, telefono, email;
    private Date fechaCreacion;
    private EntidadBancaria entidadBancaria;

    public SucursalBancaria() {
    }

    public SucursalBancaria(int idSucursalBancaria, String nombre, String codigoSucursal, String direccion, String poblacion, String codigoPostal, String telefono, String email, Date fechaCreacion, EntidadBancaria entidadBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.nombre = nombre;
        this.codigoSucursal = codigoSucursal;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
        this.entidadBancaria = entidadBancaria;
    }

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

    
    
    
    
    
}