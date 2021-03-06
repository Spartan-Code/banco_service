/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.core.BusinessException;
import java.util.List;


/**
 *
 * @author Equipo
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {
    Usuario findByNickName(String nickName)throws BusinessException;
    List<String> findbyNif();
}
