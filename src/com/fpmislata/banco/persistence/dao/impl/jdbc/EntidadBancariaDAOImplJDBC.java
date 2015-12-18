/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.core.BusinessException;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Dark
 */
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {

        try {
            EntidadBancaria entidadBancaria;
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from entidadbancaria where idEntidadBancaria=?");
            preparedStatement.setInt(1, idEntidadBancaria);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setCif(resultSet.getString("CIF"));
            }else{
                entidadBancaria= null;
            }
            
            if(resultSet.next()){
                throw new RuntimeException("Demasiadas filas devueltas");
            }
            
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadBancaria;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) throws BusinessException {

        try {
            int idTabla = 0;
            Connection connection = connectionFactory.getConnection();
            String sentencia = "Insert into entidadbancaria (nombre,codigoEntidad,fechaCreacion,direccion,CIF) Values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            if(entidadBancaria.getFechaCreacion() == null){
            preparedStatement.setDate(3, null);
            }else{           
            preparedStatement.setDate(3, new java.sql.Date(entidadBancaria.getFechaCreacion().getTime()));
            }         
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());

            int elementInsert = preparedStatement.executeUpdate();
            
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idTabla = (int) generatedKeys.getLong(1);
                }
            }
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            if(elementInsert == 1){
            return this.get(idTabla);
            }else{
             throw new RuntimeException("Se insertaron "+ elementInsert+" registros");   
            }
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 1062 && "23000".equals(ex.getSQLState())){
                throw new BusinessException("El Codigo de entidad indicado ya existe","Codigo");
            }else{
            throw new RuntimeException(ex);
            }
        }

    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) throws BusinessException {

        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE entidadbancaria SET nombre = ?, codigoEntidad = ?, fechaCreacion= ?, direccion= ?, CIF= ? where idEntidadBancaria=?");
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            if(entidadBancaria.getFechaCreacion() == null){
            preparedStatement.setDate(3, null);
            }else{           
            preparedStatement.setDate(3, new java.sql.Date(entidadBancaria.getFechaCreacion().getTime()));
            }
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.setInt(6, entidadBancaria.getIdEntidadBancaria());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return this.get(entidadBancaria.getIdEntidadBancaria());
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 1062 && "23000".equals(ex.getSQLState())){
                throw new BusinessException("El Codigo de entidad indicado ya existe","Codigo");
            }else{
            throw new RuntimeException(ex);
            }
        }

    }

    @Override
    public boolean delete(int idEntidadBancaria) {

        try {
           
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM entidadbancaria WHERE idEntidadBancaria = ?");
            preparedStatement.setInt(1, idEntidadBancaria);
            int elementsDeleted = preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            if (elementsDeleted == 0 ) {
                return false;
            } else if (elementsDeleted == 1 ) {
                return true;
            } else if (elementsDeleted >1 ) {
                throw new RuntimeException("Demasiadas filas borradas"+ elementsDeleted);
            } else {
                throw new RuntimeException("Soy un paranoico"+ elementsDeleted);
            }                                  
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }

    }

    @Override
    public List<EntidadBancaria> findAll() {

        try {
            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from entidadbancaria");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setCif(resultSet.getString("CIF"));
                entidadesBancarias.add(entidadBancaria);
            }
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadesBancarias;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {

        try {
            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from entidadbancaria where nombre=?");
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setCif(resultSet.getString("CIF"));
                entidadesBancarias.add(entidadBancaria);
            }
            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadesBancarias;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

   

}
