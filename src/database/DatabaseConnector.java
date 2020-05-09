package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static String databaseName = "inventario_productos";
    public static String hostName = "localhost";
    public static String port = "3306";
    public static String username = "root";
    public static String password = "";
    public static String url = "jdbc:mariadb://" + hostName + ":" + port + "/" +  databaseName + "?user=" + username + "&password=" + password;
    
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection(Connection c){
        try{
            c.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
