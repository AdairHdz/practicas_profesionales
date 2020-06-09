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
import mappers.UserMapper;

import pojo.UserPojo;

/**
 *
 * @author Adair Hernández
 */
public class User {

    public UserPojo getUser(String email, String password) {
        UserPojo user = null;
        try {
            user = this.handleGetUser(email, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    private UserPojo handleGetUser(String email, String password) throws SQLException{
        DatabaseConnector dc = new DatabaseConnector();
        Connection connection = dc.getConnection();
        Statement query = connection.createStatement();
        ResultSet resultSet = query.executeQuery("SELECT idUsuario, nombres, apellidos, correo, tipo"
                + " FROM Usuario WHERE correo = '" + email
                + "' AND contrasenia = '" + password + "';");
        UserMapper um = new UserMapper();
        UserPojo user = um.map(resultSet);
        return user;
    }

}
