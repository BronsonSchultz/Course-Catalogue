package db_query;

import java.sql.*;
import webApp.*;

public class CoursesQuery {
	
	public static String query() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "SELECT Subject, CourseCode, CourseName FROM Courses";	// change this to call SearchForm methods instead?
		
		try {
            // create a connection to the database
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:UofSPlanner.db");
			System.out.println("Connection to database established.");
			
            // create and execute query
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // print query results
            String results = "";
            while (rs.next()) {
                results += rs.getString("SubjectCode") + " " + rs.getString("CourseCode") + " - " + rs.getString("CourseName") + "\n";
            }
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			// close statement and connection objects to conserve DBMS resources
            try {
                if (stmt != null) stmt.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
		
		System.out.println("Query finished.");
		return results;
	}

}
