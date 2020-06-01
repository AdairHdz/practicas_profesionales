package models;
import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pojo.StudentPojo;

public class Student {
    private String holx2;
    
    public Student(){
        
    }
    
    public ArrayList<StudentPojo> getStudents(){
        try{
            Connection conn =  DatabaseConnector.getConnection();
            Statement query = conn.createStatement();
            ResultSet rs = query.executeQuery("SELECT usuario.nombres, usuario.apellidos, usuario.correo, "
                    + "usuario.contasenia, usuario.tipo, estudiante.matricula, estudiante.telefono "
                    + "FROM usuario inner join estudiante on usuario.idUsuario = estudiante.idUsuario;");
            DatabaseConnector.closeConnection(conn);
            ArrayList<StudentPojo> students;
            students = new ArrayList<>();
            while(rs.next()){
                StudentPojo student = new StudentPojo();
                
                student.setName(rs.getString("nombres"));
                student.setLastName(rs.getString("apellidos"));
                student.setEmail(rs.getString("correo"));
                student.setPassword("contasenia");
                student.setStudentEnrollment(rs.getString("matricula"));
                student.setStudentPhone(rs.getString("telefono"));
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
            ResultSet rs = query.executeQuery("SELECT usuario.nombres, usuario.apellidos, usuario.correo, "
                    + "usuario.contasenia, estudiante.matricula, estudiante.telefono "
                    + "FROM usuario inner join estudiante on usuario.idUsuario = estudiante.idUsuario "
                    + "WHERE estudiante.matricula = '"+enrollment+"';");
            DatabaseConnector.closeConnection(conn);
            StudentPojo student = new StudentPojo();
            while(rs.next()){

                student.setName(rs.getString("nombres"));
                student.setLastName(rs.getString("apellidos"));
                student.setEmail(rs.getString("correo"));
                student.setPassword("contasenia");
                student.setStudentEnrollment(rs.getString("matricula"));
                student.setStudentPhone(rs.getString("telefono"));
            }
            return student;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        
}

/*
    public ArrayList<StudentPojo> getStudentsName() throws SQLException{
        try{
            Connection connection = DatabaseConnector.getConnection();
            Statement query = connection.createStatement();
            ResultSet rs = query.executeQuery("select usuario.nombres from usuario "
                    + "inner join estudiante on usuario.idUsuario = estudiante.idUsuario");
            DatabaseConnector.closeConnection(connection);
            ArrayList<StudentPojo> student;
            student = new ArrayList<>();
            rs.next();
            
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
*/
}
