package webApp;

import webApp.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDeleter {
    DBConnection db;

    public CourseDeleter() {
        db = new DBConnection();
    }

    public static void main(String[] args) throws SQLException{
        CourseDeleter d = new CourseDeleter();
        d.clearFavForUser("1");
    }

    public void clearFavForUser(String userID) throws SQLException {
        String sql = "DELETE FROM FavouriteList " +
                "WHERE UserID = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = db.getConn();
            stmt = conn.prepareStatement(sql);
            // create statement with sql template
            stmt.setString(1, userID);

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

    public void deleteCompletedForUser(String SubjectCode, String courseCode, String userID) throws SQLException {
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
