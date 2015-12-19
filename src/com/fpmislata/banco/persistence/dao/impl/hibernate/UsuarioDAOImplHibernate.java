/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario> implements UsuarioDAO  {

    @Override
    public List<Usuario> findByNombre(String nombre) {
        return null;
    }
    
}
