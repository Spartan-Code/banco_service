/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;


import com.aeat.valida.Validador;
import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.core.BusinessMessage;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dark
 */
public class EntidadBancariaServiceImpl extends GenericServiceImpl<EntidadBancaria> implements EntidadBancariaService {

    @Autowired
    EntidadBancariaDAO entidadBancariaDAO;

    

//    static final private Pattern patternCodigoEntidad = Pattern.compile("[0-9]{4}");
//    static final private Pattern patternNombre = Pattern.compile("\\w{5,50}");
//    static final private Pattern patternDireccion = Pattern.compile("\\w{20,100}");

    public EntidadBancariaServiceImpl() {
    }

    @PostConstruct 
    public void asignarDAO() {
        this.genericDAO = entidadBancariaDAO;
    }

    
    
    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        return entidadBancariaDAO.findByNombre(nombre);
    }

    @Override
    public void insertupdateValidation(EntidadBancaria entidadBancaria) throws BusinessException {
        List<BusinessMessage> businessMessages = new ArrayList<>();
        Validador validador = new Validador();
        
//        if (entidadBancaria.getCodigoEntidad() == null || entidadBancaria.getCodigoEntidad().isEmpty()) {
//            businessMessages.add(new BusinessMessage("El campo codigo no puede estar vacio", "Codigo"));
//        } else {
//            Matcher matcher = patternCodigoEntidad.matcher(entidadBancaria.getCodigoEntidad());
//            if (!matcher.matches()) {
//                businessMessages.add(new BusinessMessage("El campo codigo debe contener cuatro numeros del 0 al 9", "Codigo"));
//            }
//        }
//
//        if (entidadBancaria.getNombre() == null || entidadBancaria.getNombre().isEmpty()) {
//            businessMessages.add(new BusinessMessage("El campo Nombre no puede estar vacio", "Nombre"));
//        } else {
//            Matcher matcher = patternNombre.matcher(entidadBancaria.getNombre());
//            if (!matcher.matches()) {
//                businessMessages.add(new BusinessMessage("El campo Nombre debe contener entre 5 y 50 caracteres.", "Nombre"));
//            }
//        }
//
//        if (entidadBancaria.getFechaCreacion() == null) {
//            businessMessages.add(new BusinessMessage("El campo Fecha no puede estar vacio", "Fecha"));
//        }
//
//        if (entidadBancaria.getDireccion() == null || entidadBancaria.getDireccion().isEmpty()) {
//            businessMessages.add(new BusinessMessage("El campo Direccion no puede estar vacio", "Direccion"));
//        } else {
//            Matcher matcher = patternDireccion.matcher(entidadBancaria.getDireccion());
//            if (!matcher.matches()) {
//                businessMessages.add(new BusinessMessage("El campo Direccion debe contener entre 20 y 100 caracteres.", "Direccion"));
//            }
//        }

        if (entidadBancaria.getCif() == null || entidadBancaria.getCif().isEmpty()) {
            businessMessages.add(new BusinessMessage("El campo CIF no puede estar vacio", "CIF"));
        } else {
            int ret = validador.checkNif(entidadBancaria.getCif());
               
            if ( ret > 0) {
                
            }else{
                businessMessages.add(new BusinessMessage("El campo CIF introducido es incorrecto", "CIF"));
            }
        }

        if (businessMessages.isEmpty()) {

        } else {
            throw new BusinessException(businessMessages);
        }
    }
}
