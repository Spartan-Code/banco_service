/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.domain;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Dark
 */
public class EntidadBancaria implements Serializable {

    private int idEntidadBancaria;

    
    @NotBlank
    @Size(min = 5, max = 50)
    private String nombre;
    @NotBlank
    @Pattern(regexp="[0-9]{4}")
    private String codigoEntidad;
    @NotBlank
    @Size(min = 20, max = 100)
    private String direccion;
    private String cif;
    private Date fechaCreacion;

    public EntidadBancaria(int idEntidadBancaria, String nombre, String codigoEntidad, String direccion, String cif, Date fechaCreacion) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
        this.codigoEntidad = codigoEntidad;
        this.direccion = direccion;
        this.cif = cif;
        this.fechaCreacion = fechaCreacion;
    }

    public EntidadBancaria() {
        this.fechaCreacion = new Date();
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
