package repository;
import java.sql.*;
public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/sms_db";
    private static final String username = "root";
    private static final String password = "91_@Days";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }
}

