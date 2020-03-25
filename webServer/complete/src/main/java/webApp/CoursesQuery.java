package webApp;

import java.sql.*;
import java.util.ArrayList;

import webApp.Course;

public class CoursesQuery {
	
	public static ArrayList<Course> query(String sql) {
		Connection conn = null;
		Statement stmt = null;
		ArrayList<Course> rsCourses = new ArrayList<Course>();
		
		try {
            // create a connection to the database
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:UofSPlanner.db");
			System.out.println("Connection to database established.");
			
            // create and execute query
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // print query results
            while (rs.next()) {
            	rsCourses.add(new Course(rs.getString("SubjectCode"), rs.getInt("CourseCode"), rs.getString("CourseName"), rs.getString("Description")));
//                System.out.println(rs.getString("SubjectCode") + " " + rs.getString("CourseCode"));
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

//        System.out.println("Query finished.");
		return rsCourses;
	}

	public static void main(String[] args) throws Exception {
		query("SELECT SubjectCode, CourseCode, CourseName, Description FROM Courses");
	}

}
