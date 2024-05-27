package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    
    private static Connection connection;
    
    private SingletonConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8111/VBookMaster", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getInstance() throws SQLException {
        if (connection == null)
            new SingletonConnection();
        return connection;
    }
}
