/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service;

import com.fpmislata.banco.business.domain.CredencialesBancarias;
import com.fpmislata.banco.core.BusinessException;
import java.math.BigDecimal;

/**
 *
 * @author German
 */
public interface PeticionRetirarDineroService {
    
    
    void sendPeticionBancaria(CredencialesBancarias credencialesBancarias, String cccOrigen, String concepto, BigDecimal importe,String codigoEntidadBancaria)throws BusinessException;
    
}
