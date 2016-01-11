/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import org.hibernate.Session;

/**
 *
 * @author Equipo
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario> implements UsuarioDAO  {

    @Override
    public Usuario findByNickName(String nickName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Usuario usuario =(Usuario)session.createQuery("SELECT e FROM user  e where nombre="+nickName).uniqueResult();        
        session.getTransaction().commit();
        session.close();
        return usuario;
    }

    
    
}
