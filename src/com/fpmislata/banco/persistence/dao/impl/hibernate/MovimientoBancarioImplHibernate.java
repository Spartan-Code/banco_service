/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.MovimientoBancario;
import com.fpmislata.banco.persistence.dao.MovimientoBancarioDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Equipo
 */
public class MovimientoBancarioImplHibernate extends GenericDAOImplHibernate<MovimientoBancario> implements MovimientoBancarioDAO {

    @Override
    public List<MovimientoBancario> findByidCuentaBancaria(int idCuentaBancaria) {
        
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT m FROM MovimientoBancario m WHERE m.cuentaBancaria.idCuentaBancaria = :idCuentaBancaria");
        query.setInteger("idCuentaBancaria",idCuentaBancaria);       

        return query.list();
    }
    
}
