package database;

import java.sql.*;

public class ReadRecords {

    public static void readRecords(String sqlQuery) {
        Connection conn = null;
        Statement stmt = null;


        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
            conn.setAutoCommit(false);
            //   System.out.println("Opened database successfully");

            stmt = conn.createStatement();

            //String findByNameQuery= "SELECT * FROM accounts WHERE name='"+name+"'";
            ResultSet rs=stmt.executeQuery(sqlQuery);
            accountsDisplay(rs);
//            while (rs.next()) {
//                System.out.println(rs.getInt("id") +  "\t" +
//                        rs.getString("name") + "\t" +
//                        rs.getString("savings")+"\t"+
//                        rs.getString("checking"));
//            }
            stmt.close();
            conn.commit();
            conn.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void accountsDisplay(ResultSet rs) throws SQLException {
        while (rs.next()) {
            System.out.println(rs.getInt("id") +  "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("savings")+"\t"+
                    rs.getString("checking"));
        }
    }
}
