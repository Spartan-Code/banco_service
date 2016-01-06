/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;


import com.fpmislata.banco.business.service.GenericService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.GenericDAO;
import java.lang.reflect.ParameterizedType;



import java.util.List;



/**
 *
 * @author German
 */
public class GenericServiceImpl<T> implements GenericService<T> {
    
    GenericDAO<T> genericDAO;
    
    @Override
    public T get(int id)throws BusinessException {
//          this.getValidation();
          return genericDAO.get(id);
    }

    @Override
    public boolean delete(int id) throws BusinessException {
//        this.deleteValidation();
        return genericDAO.delete(id);
    }

    @Override
    public T insert(T t) throws BusinessException {
        this.insertupdateValidation(t);
        return genericDAO.insert(t);
    }

    @Override
    public T update(T t)  throws BusinessException {
        this.insertupdateValidation(t);
         return genericDAO.update(t);
         
    }

    @Override
    public List<T> findAll() throws BusinessException {
//         this.findallValidation();
         return genericDAO.findAll();
    }

    @Override
    public T defaultValue() {
        T t;
        try {
            t = getEntityClass().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return t ;
    }
   private Class<T> getEntityClass() {
         return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
     }
   
   public void insertupdateValidation(T t)throws BusinessException {
       
   }
   
   public void deleteValidation()throws BusinessException {
       
   }
   
   public void getValidation()throws BusinessException {
       
   }
   
   public void findallValidation()throws BusinessException {
       
   }
   
  
   
    
    
    
    
}
