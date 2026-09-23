package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String DRIVER = ("com.mysql.cj.jdbc.Driver");
    private static final String URL = ("jdbc:mysql://localhost:3307/ProductManagement?createDatabaseIfNotExist=true");
    private static final String USER = ("root");
    private static final String PASSWORD = ("123456");

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
