package utils;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static final String DRIVER = ("com.mysql.cj.jdbc.Driver");
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";
    public static final String URL = "jdbc:mysql://localhost:3307/shop_management?createDatabaseIfNotExist=true";
    public static Connection openConnection(){
        try {
            Class.forName(DRIVER);
            Connection conn = null;
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
