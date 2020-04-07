package webApp;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DegreeSelector extends Selector {


    /**
     * create a new instance of a CourseQueries object
     */
    public DegreeSelector() {
        super();
    }


    public static void main(String args[]) throws SQLException{
        DegreeSelector d = new DegreeSelector();
        ArrayList<HashMap<String, String>> l = d.getDegreesFromDB("Computer Science");
        System.out.println(l);
    }

    /**
     * query the database for specified degrees
     * @param programName the program name the degrees belong to e.g. "Computer Science"
     * @return an array list of hashMaps, where each map contains the ProgramName, Degree and SchoolingLevel of the degree
     * @throws SQLException if a connection to the database cannot be established
     */
    public ArrayList<HashMap<String, String>> getDegreesFromDB(String programName) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<HashMap<String, String>> mappedDegrees = new ArrayList<>();

        try {
            conn = db.getConn();
            String sql = "SELECT * FROM Degrees d " +
                    "WHERE ProgramName = ?";

            // create statement with sql template
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, programName);

            // get results
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                HashMap<String, String> degree = new HashMap<>();
                degree.put("ProgramName", rs.getString("ProgramName"));
                degree.put("Degree", rs.getString("Degree"));
                degree.put("SchoolingLevel", rs.getString("SchoolingLevel"));
                mappedDegrees.add(degree);
            }

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
        return mappedDegrees;
    }
}
