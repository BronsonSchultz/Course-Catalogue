package webApp.db;

import java.sql.*;

public class DBConnection {

    public DBConnection() {

    }


    public Connection getConn() {
        Connection conn = null;
        try {

            // create a connection to the database
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:UofSPlanner.webApp.db");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public void close(Connection conn) throws SQLException {
        conn.close();
    }

    public static void main(String[] args) throws SQLException{
       DBConnection db = new DBConnection();
       Connection conn = db.getConn();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM Courses");
       System.out.println(rs.getString("CourseCode"));
    }

}
