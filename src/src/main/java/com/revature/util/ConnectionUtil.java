package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    //private static instance
    private static Connection conn = null;
    //private constructor
    private ConnectionUtil() {
    }

    public static Connection getConn() {
        try{
            if (conn != null && !conn.isClosed()) {
                return conn;
            }
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
            return null;
        }
        //Storing info in environment variables made in run environment (TestConnection atm)
//        String url = System.getenv("url");
//        String username = System.getenv("username");
//        String password = System.getenv("password");

        String url;
        String username;
        String password;
        Properties prop = new Properties();

        try{
            //prop.load(new FileReader("src/main/resources/application.properties"));
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
