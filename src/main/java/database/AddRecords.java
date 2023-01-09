package database;
import java.sql.*;

public class AddRecords {

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
//            String insertRecord="INSERT INTO accounts (?,?) " +
//                    "VALUES ('"+name+"','"+check+"');";
            stmt.executeUpdate(sqlStatement);

            stmt.close();
            conn.commit();
            conn.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
          System.out.println("Account created successfully");
    }
}
