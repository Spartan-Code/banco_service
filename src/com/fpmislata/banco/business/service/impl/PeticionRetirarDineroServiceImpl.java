/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.CredencialesBancarias;
import com.fpmislata.banco.business.domain.Extraccion;
import com.fpmislata.banco.business.service.PeticionRetirarDineroService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.util.json.JsonTransformer;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author German
 */
public class PeticionRetirarDineroServiceImpl implements PeticionRetirarDineroService {

    @Autowired
    JsonTransformer jsonTransformer;

    @Override
    public void sendPeticionBancaria(CredencialesBancarias credencialesBancarias, String cccOrigen, String concepto, BigDecimal importe, String codigoEntidadBancaria) throws BusinessException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            Extraccion extraccion = new Extraccion();

            extraccion.setCodigoCuentaCliente(cccOrigen);
            extraccion.setCodigoEntidadBancaria(codigoEntidadBancaria);
            extraccion.setConcepto(concepto);
            extraccion.setImporte(importe);
            extraccion.setPin(credencialesBancarias.getPin());

            HttpPost httpPost = new HttpPost(credencialesBancarias.getUrl() + "/retirar");
            StringEntity stringEntity = new StringEntity(jsonTransformer.toJson(extraccion));
            httpPost.setEntity(stringEntity);
            httpPost.setHeader("Content-type", "application/json");
            httpClient.execute(httpPost);
        } catch (IOException ex) {
            Logger.getLogger(BancoCentralServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new BusinessException("Error por cuestiones ajenas", "BancoCentral");
        } finally {
            try {
                httpClient.close();
            } catch (IOException ex) {
                Logger.getLogger(BancoCentralServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
