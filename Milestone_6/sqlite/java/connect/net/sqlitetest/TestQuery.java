package net.sqlitetest;

import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestQuery {

    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/sqlite/db/UofSPlanner.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to the SQLite3 database has been established.");

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

    public static void main(String[] args) {
        connect();
    }
}