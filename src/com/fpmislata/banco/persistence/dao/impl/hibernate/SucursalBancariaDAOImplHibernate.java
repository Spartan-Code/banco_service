/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.hibernate;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.persistence.dao.SucursalBancariaDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Equipo
 */
public class SucursalBancariaDAOImplHibernate extends GenericDAOImplHibernate<SucursalBancaria> implements SucursalBancariaDAO {

    @Override
    public List<SucursalBancaria> findByidEntidadBancaria(int idEntidadBancaria) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT s FROM SucursalBancaria s WHERE s.entidadBancaria.idEntidadBancaria = :idEntidadBancaria");
        query.setInteger("idEntidadBancaria", idEntidadBancaria);

        List<SucursalBancaria> sucursalesBancarias = query.list();

        return sucursalesBancarias;

    }

    @Override
    public List<String> findbyCodigoSucursal() {
        Session session = sessionFactory.getCurrentSession();
        
        Query query = session.createQuery("SELECT new map(s.idSucursalBancaria as id ,s.codigoSucursal as codigo) FROM  SucursalBancaria s");
                
        return query.list();
    }

}
