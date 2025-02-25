package dev.ernandorezende.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static Connection connection = null;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/learning-db";
        String user = "root";
        String password = "secret";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, password);

        System.out.println("Connected successful.");
        return connection;
    }

    public static void close(){
        try{
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed connecting to the database. "+ e.getMessage());
        }
    }
}
