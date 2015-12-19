/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.Usuario;
import java.util.List;

/**
 *
 * @author Equipo
 */
public interface UsuarioService extends GenericService<Usuario> {
    
    List<Usuario> findByNombre(String nombre);
}
