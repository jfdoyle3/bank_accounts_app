package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadRecords {

    public static void main(String args[]) {
        Connection conn = null;
        Statement stmt = null;
        String name="Jim";

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
            conn.setAutoCommit(false);
            //   System.out.println("Opened database successfully");

            stmt = conn.createStatement();

            String findByNameQuery= "SELECT * FROM accounts WHERE name='"+name+"'";
            ResultSet rs=stmt.executeQuery(findByNameQuery);
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("savings")+"\t"+
                        rs.getString("checking"));
            }
            stmt.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
