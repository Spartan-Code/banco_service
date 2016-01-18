/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Equipo
 */
public class UsuarioDAOImplHibernate extends GenericDAOImplHibernate<Usuario> implements UsuarioDAO  {

    @Override
    public Usuario findByNickName(String nickName) throws BusinessException {
        Session session = sessionFactory.getCurrentSession();
        
        Usuario usuario = (Usuario) session.createQuery("SELECT u FROM Usuario u WHERE nickName = :nickName").setParameter("nickName", nickName).uniqueResult();
        
        if(usuario==null){
            throw new BusinessException("El usuario no existe","usuario");
        }else{
        return usuario;
        }
    }

    @Override
    public List<String> findbyNif() {
        Session session = sessionFactory.getCurrentSession(); 
         Query query = session.createQuery("SELECT u.nif FROM  Usuario u");
         List<String> nifs = query.list();
         return nifs;
    }

    
    
}
