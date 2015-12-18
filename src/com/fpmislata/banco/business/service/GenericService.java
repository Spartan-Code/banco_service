/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.core.BusinessException;
import java.util.List;

/**
 *
 * @author German
 */
public interface GenericService<T> {
    
    T get(int id)throws BusinessException;
    boolean delete(int id)throws BusinessException;
    T insert(T t)throws BusinessException;
    T update(T t) throws BusinessException;
    List<T> findAll()throws BusinessException;
    T defaultValue();
    
    
}
