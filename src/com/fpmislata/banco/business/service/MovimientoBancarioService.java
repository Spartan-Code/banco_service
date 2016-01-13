/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;


import com.fpmislata.banco.business.domain.MovimientoBancario;
import java.util.List;

/**
 *
 * @author Equipo
 */
public interface MovimientoBancarioService extends GenericService<MovimientoBancario> {
    List<MovimientoBancario> findByNombre(String nombre);
}
