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
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        T t = (T) session.get(this.getEntityClass(), id);

        session.getTransaction().commit();
        session.close();

        return t;
    }

    @Override
    public boolean delete(int id) {
        boolean borrado;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T t = this.get(id);
        if (t == null) {
            borrado = false;
        } else {

            session.delete(t);
            borrado = this.get(id) != null;

        }
        session.getTransaction().commit();
        session.close();
        return borrado;
    }

    @Override
    public T insert(T t) throws BusinessException {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(t);

        session.getTransaction().commit();
        session.close();

        return t;

    }

    @Override
    public T update(T t) throws BusinessException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(t);

        session.getTransaction().commit();
        session.close();

        return t;
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
        List<T> entities = query.list();
        session.getTransaction().commit();
        session.close();
        return entities;
    }

}
