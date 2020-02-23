import java.sql.*;

public class TestQuery {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.sqlite3.jdbc.Driver";
    static final String DB_URL = "jdbc:sqlite3://localhost/EMP";

    // credentials
    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // register JDBC driver
            Class.forName("com.sqlite3.jdbc.Driver");

            // open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // execute query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT CourseCode FROM Courses";
            ResultSet rs = stmt.executeQuery(sql);

            // extract data from result set object
            while (rs.next()) {
                // retrieve by column name
                int id  = rs.getInt("CourseCode");

                // display values
                System.out.print("Code: " + id);
            }

            rs.close();
            stmt.close();
            conn.close();
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
            catch(SQLException se2) {
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
}