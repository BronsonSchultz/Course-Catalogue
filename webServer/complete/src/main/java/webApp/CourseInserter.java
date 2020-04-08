package webApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import webApp.db.DBConnection;

public class CourseInserter {
    DBConnection db;

    public CourseInserter() {
        db = new DBConnection();
    }

    public void insertFavForUser(String SubjectCode, String courseCode, String userID) throws SQLException {
        String sql = "INSERT INTO FavouriteList (SubjectCode, CourseCode, UserID) " +
                "VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = db.getConn();
            stmt = conn.prepareStatement(sql);
            // create statement with sql template
            stmt.setString(1, SubjectCode);
            stmt.setString(2, courseCode);
            stmt.setString(3, userID);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            // close statement and connection objects to conserve DBMS resources
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }


        // close statement and connection objects to conserve DBMS resources

    }

    public void insertCompletedForUser(String SubjectCode, String courseCode, String userID) throws SQLException {
        String sql = "INSERT INTO CompletedList (SubjectCode, CourseCode, UserID) " +
                "VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = db.getConn();
            stmt = conn.prepareStatement(sql);
            // create statement with sql template
            stmt.setString(1, SubjectCode);
            stmt.setString(2, courseCode);
            stmt.setString(3, userID);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            // close statement and connection objects to conserve DBMS resources
            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }
}
