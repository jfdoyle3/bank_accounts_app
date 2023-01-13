package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseOperations {
    public static void addRecord(String sqlStatement) {
        Connection conn = null;
        Statement stmt = null;
        String name="xxx";
        String check="111";

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
            conn.setAutoCommit(false);
            //   System.out.println("Opened database successfully");
           stmt = conn.createStatement();
//

            /*
                Try to keep this one class and call
                methods and return response.
                addRecord();

            */

            stmt.close();
            conn.commit();
            conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Account created successfully");
    }

//    public Statement addRecord(sqlStatement) {
//        return stmt.executeUpdate(sqlStatement);
//    }
}
