package dataPartioning;
import java.sql.*;

public class DBconnection {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "username";
   static final String PASS = "password";
   
   public Connection getDB() throws ClassNotFoundException, SQLException {
   Connection conn = null;
   Statement stmt = null;

     Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Connecting to database...");

      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      stmt = conn.createStatement();
      
      String sql = "CREATE DATABASE STUDENTS";
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");

      return conn;

}
}