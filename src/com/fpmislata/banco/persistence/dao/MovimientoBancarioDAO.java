/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao;

import com.fpmislata.banco.business.domain.MovimientoBancario;
import java.util.List;

/**
 *
 * @author Equipo
 */
public interface MovimientoBancarioDAO extends GenericDAO<MovimientoBancario> {
    List<MovimientoBancario> findByidCuentaBancaria(int idCuentaBancaria);
}
