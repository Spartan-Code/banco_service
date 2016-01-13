/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.business.service.UsuarioService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.UsuarioDAO;
import com.fpmislata.banco.security.PasswordManager;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Equipo
 */
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario> implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;
    
    @Autowired
    PasswordManager passwordManager;

    public UsuarioServiceImpl() {
    }
    
    
    

    @PostConstruct 
    public void asignarDAO() {
        this.genericDAO = usuarioDAO;
    }
    
    
    
    
    @Override
    public Usuario findByNickName(String nickName)throws BusinessException {
        return usuarioDAO.findByNickName(nickName);
    }
    
    
    @Override
    public Usuario insert(Usuario usuario) throws BusinessException {
        usuario.setPasswordEncrypt(passwordManager.encrypt(usuario.getPasswordEncrypt()));
        return genericDAO.insert(usuario);
    }
}
