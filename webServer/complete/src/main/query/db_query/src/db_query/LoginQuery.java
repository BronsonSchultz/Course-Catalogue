package db_query;

import java.sql.*;

public class LoginQuery {
	
	public static void query(String sql) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
            // create a connection to the database
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:UofSPlanner.webApp.db");
			System.out.println("Connection to database established.");
			
            // create and execute query
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // print query results
            while (rs.next()) {
                System.out.println(rs.getString("Username") + " " + rs.getString("Password"));
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
	}

	public static void main(String[] args) throws Exception {
		query("SELECT UserID FROM Users WHERE Username=? AND Password=?");
	}

}
