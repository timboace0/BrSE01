package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static final String DRIVER = ("com.mysql.cj.jdbc.Driver");
    public static final String URL = ("jdbc:mysql://localhost:3307/student_management?createDatabaseIfNotExist=true");
    public static final String USERNAME = ("root");
    public static final String PASSWORD = ("123456");

    public static Connection openConnection(){
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conn;
        } catch (RuntimeException | SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
