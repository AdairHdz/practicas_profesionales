/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pojo.UserPojo;

/**
 *
 * @author Adair Hernández
 */
public class User {
    
    public UserPojo getUser(String email, String password){
        Connection connection = DatabaseConnector.getConnection();
        UserPojo user = new UserPojo();
        try{
            Statement query = connection.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT nombres, apellidos,"
                    + " correo, contrasenia FROM Usuario"
                    + " WHERE correo = '" + email
                    + "' AND contrasenia = '" + password + "'");
            while(resultSet.next()){
                user.setName(resultSet.getString("nombres"));
                user.setLastName(resultSet.getString("apellidos"));
                user.setEmail(resultSet.getString("correo"));
                user.setPassword(resultSet.getString("contrasenia"));            
            }
            
        }catch(SQLException e){
            
        }
        return user;
    }
    
}
