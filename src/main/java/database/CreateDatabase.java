package database;

import java.sql.*;

public class CreateDatabase {

    public static void createDatabase() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:bank.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String savingsTable = "CREATE TABLE IF NOT EXISTS SAVINGS(\n" +
                    "ID INT PRIMARY KEY     NOT NULL,\n" +
                    " NAME           TEXT    NOT NULL,\n" +
                    " ACCOUNT            INT     NOT NULL,\n" +
                    " AMOUNT        INT,\n" +
                    " BALANCE         INT\n" +
                    ")";
            String checkingTable = "CREATE TABLE IF NOT EXISTS checking (\n"
                    + "id integer PRIMARY KEY NOT NULL,\n"
                    + " ACCOUNT            INT     NOT NULL,\n"
                    + " AMOUNT        INT,\n"
                    + " BALANCE         INT\n"
                    + ")";


            String accountsTable = "CREATE TABLE IF NOT EXISTS accounts (\n"
                    + " id integer PRIMARY KEY,\n"
                    + " name text NOT NULL,\n"
                    + " savings-account integer,\n"
                    + " checking-account integer,\n"
                    + ");";

            stmt.executeUpdate(savingsTable);
            stmt.executeUpdate(checkingTable);
            stmt.executeUpdate(accountsTable);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Database created successfully");
    }
}