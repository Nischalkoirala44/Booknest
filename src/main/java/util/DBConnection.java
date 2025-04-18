package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Database configuration information
    private static final String URL = "jdbc:mysql://localhost:3306/bookhub";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Establish connection to the database
    public static Connection getDbConnection() throws SQLException {
        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
    }
}
