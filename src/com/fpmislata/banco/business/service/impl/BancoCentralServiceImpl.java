/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.business.service.impl;

import com.fpmislata.banco.business.domain.CredencialesBancarias;
import com.fpmislata.banco.business.service.BancoCentralService;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.util.json.JsonTransformer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Equipo
 */
public class BancoCentralServiceImpl implements BancoCentralService {

    @Autowired
    JsonTransformer jsonTransformer;

    @Override
    public CredencialesBancarias getURLbyCCC(String ccc) throws BusinessException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet("");

//            System.out.println("GET Response Status:: "
//                    + httpResponse.getStatusLine().getStatusCode());
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String response = httpClient.execute(httpGet, responseHandler);
            return jsonTransformer.fromJSON(response, CredencialesBancarias.class);
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

    @Override
    public CredencialesBancarias getURLbyCCCLocal(String ccc) throws BusinessException {

        if (!ccc.matches("[0-9]{20}")) {
            throw new BusinessException("La cuenta origen contener 20 digitos", "CCC");
        }
        if (ccc.substring(0, 4).matches("^0[0-9]{3}")) {
            return new CredencialesBancarias("", "2222");
        }
        if (ccc.substring(0, 4).matches("^1[0-9]{3}")) {
            return new CredencialesBancarias("", "2222");
        }
        if (ccc.substring(0, 4).matches("^2[0-9]{3}")) {
            return new CredencialesBancarias("", "2222");
        }

        throw new BusinessException("La Entidad Bancaria esta fuera de nuestro rango ", "CCC");

    }

}
