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
import pojo.RecordPojo;

/**
 *
 * @author Adair Hernández
 */
public class Record {
    
    public RecordPojo getRecord(String enrollment){
        Connection connection = DatabaseConnector.getConnection();
        RecordPojo record = null;
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT calificacionFinal,"
                    + "comentarios, totalHorasRealizadas "
                    + "FROM Expediente WHERE matricula = '" + enrollment + "';");
            while(resultSet.next()){
                record = new RecordPojo();
                record.setFinalGrade(resultSet.getFloat("calificacionFinal"));
                record.setComments(resultSet.getString("comentarios"));
                record.setTotalHoursCovered(resultSet.getInt("totalHorasRealizadas"));
            }
        }catch(SQLException e){
            
        }
        return record;
    }
}
