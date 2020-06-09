package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    protected String hostName;
    protected String port;
    private final String databaseName;
    private final String username;
    private final String password;
    private Connection uniqueInstance;

    //public static String url = "jdbc:mariadb://" + hostName + ":" + port + "/" +  databaseName + "?user=" + username + "&password=" + password;
    
    
    public DatabaseConnector() {
        this.hostName = "localhost";
        this.port = "3306";
        this.databaseName = "sistemapp";
        this.username = "root";
        this.password = "";
    }

    /**
     * Este método devuelve una única instancia del objeto Connection.
     * En caso de que no exista una instancia, esta se crea y se retorna; si 
     * por el contrario ya existe una instancia, no se crea otra, sino que se
     * retorna la existente.
     * @return una única instancia del objeto Connection.
     */
    public Connection getConnection() {
        if (uniqueInstance == null) {
            try {
                this.handleGetconnection();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return uniqueInstance;
    }

    /**
     * Inicializa el objeto Connection.
     * @throws SQLException 
     */
    private void handleGetconnection() throws SQLException {
        uniqueInstance = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sistemapp?user=root&password=");
    }

    /**
     * Cierra la conexión con la base de datos y asigna null al objeto
     * Connection.
     */
    public void closeConnection() {
        try {
            this.uniqueInstance.close();
            this.uniqueInstance = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
