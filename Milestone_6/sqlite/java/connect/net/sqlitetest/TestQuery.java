package net.sqlitetest;

import java.lang.String;
import java.sql.*;

public class TestQuery {

    public static void connect() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:UofSPlanner.db";

            Class.forName("org.sqlite.JDBC");

            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to the SQLite3 database has been established.");
            stmt = conn.createStatement();
            String sql = "SELECT CourseCode FROM Courses";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getInt("CourseCode"));
            }

        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) stmt.close();
            }
            catch(SQLException se2){
            }
            try {
                if (conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

    public static void main(String[] args) {
        connect();
    }
}
