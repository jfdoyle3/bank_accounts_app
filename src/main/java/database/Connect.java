package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static void connectSQLite() {
        Connection conn = null;
        String dbName="bank";
        String dbPath="C:/sqlite/"+dbName+".db";
        try {
            // db parameters
            String url = "jdbc:sqlite:"+dbPath;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connectSQLite();


    }


}