/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.jdbc;



import java.sql.Connection;



/**
 *
 * @author Dark
 */
public interface ConnectionFactory {
    
    public Connection getConnection();
    
    public void closeConnection(Connection connection);
    
}
