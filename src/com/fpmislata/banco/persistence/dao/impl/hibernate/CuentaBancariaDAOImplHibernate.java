/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.CuentaBancaria;
import com.fpmislata.banco.persistence.dao.CuentaBancariaDAO;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class CuentaBancariaDAOImplHibernate extends GenericDAOImplHibernate<CuentaBancaria> implements CuentaBancariaDAO {

    @Override
    public CuentaBancaria findByNumeroCuenta(String numeroCuenta) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numeroCuenta = :numeroCuenta");
        query.setString("numeroCuenta", numeroCuenta);

        CuentaBancaria cuentaBancaria = (CuentaBancaria) query.uniqueResult();

        return cuentaBancaria;
    }

}
