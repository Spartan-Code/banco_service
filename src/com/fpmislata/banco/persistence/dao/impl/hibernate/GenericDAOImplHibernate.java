/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.GenericDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Equipo
 */
public class GenericDAOImplHibernate<T> implements GenericDAO<T> {

    SessionFactory sessionFactory;

    public GenericDAOImplHibernate() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T get(int id) {
        Session session = sessionFactory.getCurrentSession();
        

        T t = (T) session.get(this.getEntityClass(), id);

        

        return t;
    }

    @Override
    public boolean delete(int id) {
        boolean borrado;
        Session session = sessionFactory.getCurrentSession();
        
        T t = this.get(id);
        if (t == null) {
            borrado = false;
        } else {
            
            session.beginTransaction();
            
            session.delete(t);
            
            
            session.getTransaction().commit();
//            borrado = this.get(id) != null;
            
             borrado=true;
        }
       
        return borrado;
    }

    @Override
    public T insert(T t) throws BusinessException {
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();

            session.save(t);

            session.getTransaction().commit();

            return t;
        } catch (javax.validation.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            throw new BusinessException(cve);
        } 

    }

    @Override
    public T update(T t) throws BusinessException {
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();

            session.update(t);

            session.getTransaction().commit();

            return t;
        } catch (ConstraintViolationException cve) {
            throw new BusinessException(cve);
        } 
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        
        Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
        List<T> entities = query.list();
        
        return entities;
    }

}
