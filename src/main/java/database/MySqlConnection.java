package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private static String dbName = "bank";
    private static String dbPath = "C:/sqlite/" + dbName + ".db";

    private static String url = "jdbc:sqlite:" + dbPath;

    private static String dbUrl = "jdbc:mysql://localhost:3306/bank?useSSL=true";
    private static String dbUsername = "username";
    private static String dbPassword = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    public static Connection getConnectionSQLite() throws SQLException {
        return DriverManager.getConnection(url);
    }

    // db parameters

    // create a connection to the database

}