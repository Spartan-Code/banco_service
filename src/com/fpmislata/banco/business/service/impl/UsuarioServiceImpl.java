/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.business.service.UsuarioService;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService {

    @Override
    public List<Usuario> findByNombre(String nombre) {
        return null;
    }
    
}
