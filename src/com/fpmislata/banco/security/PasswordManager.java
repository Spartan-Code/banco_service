/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.security;

/**
 *
 * @author German
 */
public interface PasswordManager {
    String encrypt(String password);
    boolean check (String password, String encrypt);
    
}
