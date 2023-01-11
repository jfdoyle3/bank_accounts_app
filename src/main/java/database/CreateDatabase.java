package database;

import java.sql.*;

public class CreateDatabase {

    public static void createDatabase() {
        Connection conn = null;
        Statement stmt = null;

        try {

            // Connect to SQLite and Create Database file
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:bank.db");

            stmt = conn.createStatement();

            // Create Tables
            // Savings
            String savingsTable = "CREATE TABLE IF NOT EXISTS savings(\n"
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                    + "account    TEXT                      NOT NULL,\n"
                    + "amount     INTEGER,\n"
                    + "balance    INTEGER\n"
                    + ")";

            //Checking
            String checkingTable = "CREATE TABLE IF NOT EXISTS checking (\n"
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                    + "account    TEXT                      NOT NULL,\n"
                    + "amount     INTEGER,\n"
                    + "balance    INTEGER\n"
                    + ");";

            // Accounts
            String accountsTable = "CREATE TABLE IF NOT EXISTS accounts (\n"
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n"
                    + "name TEXT        UNIQUE              NOT NULL,\n"
                    + "savings TEXT     UNIQUE,\n"
                    + "checking TEXT    UNIQUE\n"
                    + ");";

            stmt.executeUpdate(savingsTable);
            stmt.executeUpdate(checkingTable);
            stmt.executeUpdate(accountsTable);
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Database created successfully");
    }
}