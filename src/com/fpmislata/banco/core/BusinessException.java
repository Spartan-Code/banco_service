/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.core;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;

/**
 *
 * @author German
 */
public class BusinessException extends Exception{
    
    private List<BusinessMessage> businessMessages = new ArrayList<>();

    public BusinessException(List<BusinessMessage> businessMessages) {
        this.businessMessages.addAll(businessMessages);
    }
    
     public BusinessException(javax.validation.ConstraintViolationException cve) {
        for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {
            
            String fieldName = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();

            businessMessages.add(new BusinessMessage(fieldName+" : "+message, fieldName));
        }
    }
     
      public BusinessException(org.hibernate.exception.ConstraintViolationException cve) {
       
            
            
         
            String message = "El valor ya existe."+ cve.getLocalizedMessage();

            businessMessages.add(new BusinessMessage(message, ""));
        
    }


    public BusinessException(String message, String fieldName) {
        BusinessMessage businessMessage = new BusinessMessage(message, fieldName);
        businessMessages.add(businessMessage);
    }

    public List<BusinessMessage> getBusinessMessages() {
        return businessMessages;
    }

    public void setBusinessMessages(List<BusinessMessage> businessMessages) {
        this.businessMessages = businessMessages;
    }

    
}
