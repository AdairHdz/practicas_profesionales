<<<<<<< HEAD
package models;
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

>>>>>>> aaf92c49bb418bcb24acc07ee8e15bb265a01395
import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pojo.StudentPojo;

<<<<<<< HEAD
public class Student {
    private String holx2;
    
    public Student(){
        
    }
    
    public ArrayList<StudentPojo> getStudents(){
        try{
            Connection conn =  DatabaseConnector.getConnection();
            Statement query = conn.createStatement();
            ResultSet result = query.executeQuery("SELECT usuario.nombres, usuario.apellidos, usuario.correo, "
                    + "usuario.contasenia, usuario.tipo, estudiante.matricula, estudiante.telefono "
                    + "FROM usuario inner join estudiante on usuario.idUsuario = estudiante.idUsuario;");
            DatabaseConnector.closeConnection(conn);
            ArrayList<StudentPojo> students;
            students = new ArrayList<>();
            while(result.next()){
                StudentPojo student = new StudentPojo();
                student.setName(result.getString("nombres"));
                student.setLastName(result.getString("apellidos"));
                student.setEmail(result.getString("correo"));
                student.setPassword(result.getString("contasenia"));
                student.setEnrollment(result.getString("matricula"));
                student.setPhone(result.getString("telefono"));
                students.add(student);
            }
            return students;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public StudentPojo getOnlyOneStudent(String enrollment){
         try{
            Connection conn =  DatabaseConnector.getConnection();
            Statement query = conn.createStatement();
            ResultSet result = query.executeQuery("SELECT usuario.nombres, usuario.apellidos, usuario.correo, "
                    + "usuario.contasenia, estudiante.matricula, estudiante.telefono "
                    + "FROM usuario inner join estudiante on usuario.idUsuario = estudiante.idUsuario "
                    + "WHERE estudiante.matricula = '"+enrollment+"';");
            DatabaseConnector.closeConnection(conn);
            StudentPojo student = new StudentPojo();
            while(result.next()){

                student.setName(result.getString("nombres"));
                student.setLastName(result.getString("apellidos"));
                student.setEmail(result.getString("correo"));
                student.setPassword(result.getString("contasenia"));
                student.setEnrollment(result.getString("matricula"));
                student.setPhone(result.getString("telefono"));
            }
            return student;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }   
    }
}
=======
/**
 *
 * @author Adair Hernández
 */
public class Student {
    public ArrayList<StudentPojo> getStudents(){
        Connection connection = DatabaseConnector.getConnection();
        ArrayList<StudentPojo> studentsList = new ArrayList<>();
        try{
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("SELECT Usuario.nombres,"
                    + " Usuario.apellidos, Estudiante.matricula"
                    + " FROM Estudiante INNER JOIN Usuario ON "
                    + "Estudiante.idUsuario = Usuario.idUsuario");
            while(rs.next()){
                StudentPojo student = new StudentPojo();
                student.setName(rs.getString("nombres"));
                student.setLastName(rs.getString("apellidos"));
                student.setEnrollment(rs.getString("matricula"));
                studentsList.add(student);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }                
        return studentsList;
    }
}
>>>>>>> aaf92c49bb418bcb24acc07ee8e15bb265a01395
