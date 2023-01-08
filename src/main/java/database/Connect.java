package database;

import java.sql.*;

    public class Connect {
        public Connection connectToDatabase() throws SQLException, ClassNotFoundException {
            Connection conn = null;

          //  try {
                Class.forName("org.sqlite.JDBC");


//            } catch ( Exception e ) {
//                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//                System.exit(0);
//            }
            System.out.println("Opened database successfully");
            return  DriverManager.getConnection("jdbc:sqlite:bank.db");
        }
    }