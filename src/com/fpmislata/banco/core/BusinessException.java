/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintViolation;

/**
 *
 * @author German
 */
public class BusinessException extends Exception {

    private List<BusinessMessage> businessMessages = new ArrayList<>();

    public BusinessException(List<BusinessMessage> businessMessages) {
        this.businessMessages.addAll(businessMessages);
    }

    public BusinessException(javax.validation.ConstraintViolationException cve) {
        for (ConstraintViolation constraintViolation : cve.getConstraintViolations()) {

            String fieldName = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();

            businessMessages.add(new BusinessMessage(fieldName + " : " + message, fieldName));
        }
    }

    public BusinessException(org.hibernate.exception.ConstraintViolationException cve) {

        SQLException sqlException = cve.getSQLException();
        Pattern pattern;
        Matcher matcher;
        
        if (sqlException.getErrorCode() == 1062 && sqlException.getSQLState().equals("23000")) {
            pattern = Pattern.compile("Duplicate entry '(.*)' for key '(.*)'");
            matcher = pattern.matcher(sqlException.getMessage());
            if (matcher.matches()) {
                String value = matcher.group(1);
                String propertyName = matcher.group(2);
                String message = "El valor  " + value + " esta duplicado";
                businessMessages.add(new BusinessMessage(propertyName + " : " + message, propertyName));
            }
        }
        if (sqlException.getErrorCode() == 1451 && sqlException.getSQLState().equals("23000")) {
            pattern = Pattern.compile("Cannot delete or update a parent row: a foreign key constraint fails \\(`[a-zA-Z]*`.`([a-zA-Z]*)`, CONSTRAINT `[__a-zA-Z]*` FOREIGN KEY \\(`[a-zA-Z]*`\\) REFERENCES `[a-zA-Z]*` \\(`[a-zA-Z]*`\\)\\)");
            matcher = pattern.matcher(sqlException.getMessage());
            if (matcher.matches()) {
                String value = matcher.group(1);

                String message = "El valor no puede ser borrado porque  tiene " + value + " asociadas a el";
                businessMessages.add(new BusinessMessage(message, ""));
            }

//            String message = "El valor ya existe."+ cve.getLocalizedMessage();
//
//            businessMessages.add(new BusinessMessage(message, ""));
        }
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
