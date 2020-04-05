package webApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.DBConnection;

public class CourseInserter {
    DBConnection db;
    public CourseInserter(){
        db = new DBConnection();
    }

    public void insertFavForUser(String SubjectCode, String courseCode, String userID) throws SQLException {
        String sql = "INSERT INTO FavouriteList (SubjectCode, CourseCode, UserID) " +
                "VALUES (?, ?, ?)";

        try (Connection conn = db.getConn(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // create statement with sql template
            stmt.setString(1, SubjectCode);
            stmt.setString(2, courseCode);
            stmt.setString(3, userID);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

        // close statement and connection objects to conserve DBMS resources

    }
}
