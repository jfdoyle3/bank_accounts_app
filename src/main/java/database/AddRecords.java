package database;
import java.sql.*;

public class AddRecords {

    public static void addAccount(String account, int idx, String name, int save, int check) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();
            String insertRecord="INSERT INTO "+account+" (ID,NAME,SAVINGS,CHECKING) " +
                    "VALUES ("+idx+","+name+","+save+","+check+");";
//            String sql = "INSERT INTO accounts (ID,NAME,SAVINGS,CHECKING) " +
//                    "VALUES (1, 'Paul', 100100, 100101 );";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO savings (ID,ACCOUNT,AMOUNT,BALANCE) " +
//                    "VALUES (1, 100100, 25, 25);";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO checking (ID,ACCOUNT,AMOUNT,BALANCE) " +
//                    "VALUES (1,100101, 25, 25);";
            stmt.executeUpdate(insertRecord);



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
