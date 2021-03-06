package webApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import org.json.JSONObject;

/**
 * class who queries database for courses and degrees based on some search parameters
 */
public class CourseSelector extends Selector{

    /**
     * create a new instance of a CourseQueries object
     */
    public CourseSelector() {
        super();
    }


    public static void main(String[] args) throws Exception {
        //tests
        CourseSelector querier = new CourseSelector();

        /////////get courses for search tests /////////////
        // both fields present
        System.out.println("Expecting all of the CMPT courses to be at the 400-level");
        ArrayList<HashMap<String, String>> l = querier.getCoursesFromDB("CMPT", "4");
        System.out.println(l);


        // just subject present
        System.out.println("Expecting all of the CMPT courses at any level");
        l = querier.getCoursesFromDB("CMPT", "");
        System.out.println(l);

        // just course code present
        System.out.println("Expecting all of the 100-level courses from any subject");
        l = querier.getCoursesFromDB("", "1");
        System.out.println(l);


        ////////// jsonify each map in the arrayList ///////
        System.out.println("Expecting array of JSON objects");
        JSONObject[] js = querier.jsonifyList(l);
        System.out.println(Arrays.toString(js));


        ///////// get favourite courses test ///////////
        System.out.println("Expecting all of user 1's favourited courses");
        l = querier.getUserFavCourses("1");
        System.out.println(l);


        //////// get completed courses test /////////
        System.out.println("Expecting all of user 1's completed courses");
        l = querier.getUserCompletedCourses("1");
        System.out.println(l);

        //////// get courses of category c1 for all comp sci /////////
        System.out.println("Expecting all of user 1's completed courses");
        l = querier.getCategoryCourses("C1", "All", "Computer Science");
        System.out.println(l);

    }

    /**
     * query the database for specified courses
     * @param subjectCode the four letter subject code of the course(s) you're searching for, eg. "CMPT"
     * @param courseCode the first digit course number of the courses(s) you're searching for, eg. 3
     * @return an array list of hashMaps, where each map contains the SubjectCode, CourseCode, CourseName and Description of the course
     * @throws SQLException if a connection to the database cannot be established
     */
    public ArrayList<HashMap<String, String>> getCoursesFromDB(String subjectCode, String courseCode) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<HashMap<String, String>> mappedCourses = new ArrayList<>();

        try {
            conn = db.getConn();
            String base = "  SELECT SubjectCode, CourseCode, CourseName, Description " +
                    "       FROM Courses " +
                    "       WHERE ";

            String sql = "";

            String justSubject = "SubjectCode = ? ";
            String justCourse = "CourseCode LIKE ?";
            String both = justSubject + " AND " + justCourse;

            if (subjectCode.isBlank()) {
                sql = base + justCourse;
            } else if (courseCode.isBlank()) {
                sql = base + justSubject;
            } else {
                sql = base + both;
            }

            // create statement with sql template
            stmt = conn.prepareStatement(sql);

            // update it with parameters
            if (subjectCode.isBlank()) {
                stmt.setString(1, courseCode + "%");
            } else if (courseCode.isBlank()) {
                stmt.setString(1, subjectCode);
            } else {
                stmt.setString(1, subjectCode);
                stmt.setString(2, courseCode + "%");
            }

            // get results
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                HashMap<String, String> course = new HashMap<>();
                course.put("SubjectCode", rs.getString("SubjectCode"));
                course.put("CourseCode", rs.getString("CourseCode"));
                course.put("CourseName", rs.getString("CourseName"));
                course.put("Description", rs.getString("Description"));

                mappedCourses.add(course);
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
        return mappedCourses;
    }

    /**
     * query the database for the favourited courses of a user
     * @param userID the id of the logged in user
     * @return an array list of courses as hashMaps
     * @throws SQLException if a connection to the webApp.db cannot be formed
     */
    public ArrayList<HashMap<String, String>> getUserFavCourses(String userID) throws SQLException{
        String sql = "SELECT fl.FavouriteID, fl.SubjectCode, fl.CourseCode, fl.UserID, CourseName, Description FROM (FavouriteList fl" +
                " JOIN Courses " +
                "ON fl.SubjectCode = Courses.SubjectCode AND fl.CourseCode = Courses.CourseCode)" +
                "WHERE fl.UserID = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<HashMap<String, String>> mappedCourses = new ArrayList<>();

        try {
            conn = db.getConn();

            // create statement with sql template
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userID);

            // get results
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                HashMap<String, String> course = new HashMap<>();
                course.put("FavouriteID", rs.getString("FavouriteID"));
                course.put("SubjectCode", rs.getString("SubjectCode"));
                course.put("CourseCode", rs.getString("CourseCode"));
                course.put("CourseName", rs.getString("CourseName"));
                course.put("Description", rs.getString("Description"));

                mappedCourses.add(course);
            }

        } catch (SQLException e){
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

        return mappedCourses;
    }

    /**
     * query the database for the favourited courses of a user
     * @param userID the id of the logged in user
     * @return an array list of courses as hashMaps
     * @throws SQLException if a connection to the webApp.db cannot be formed
     */
    public ArrayList<HashMap<String, String>> getUserCompletedCourses(String userID) throws SQLException{
        String sql = "SELECT cl.SubjectCode, cl.CourseCode, cl.UserID, CourseName, Description FROM (CompletedList cl" +
                " JOIN Courses " +
                "ON cl.SubjectCode = Courses.SubjectCode AND cl.CourseCode = Courses.CourseCode)" +
                "WHERE cl.UserID = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<HashMap<String, String>> mappedCourses = new ArrayList<>();

        try {
            conn = db.getConn();

            // create statement with sql template
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userID);

            // get results
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                HashMap<String, String> course = new HashMap<>();
                course.put("SubjectCode", rs.getString("SubjectCode"));
                course.put("CourseCode", rs.getString("CourseCode"));
                course.put("CourseName", rs.getString("CourseName"));
                course.put("Description", rs.getString("Description"));

                mappedCourses.add(course);
            }

        } catch (SQLException e){
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

        return mappedCourses;
    }

    /**
     * query the database for the courses of a degree category
     * @param category the name of the category of courses "C1"
     * @return an array list of courses as hashMaps
     * @throws SQLException if a connection to the webApp.db cannot be formed
     */
    public ArrayList<HashMap<String, String>> getCategoryCourses(String category, String degree, String programName) throws SQLException{
        String sql = "SELECT Courses.SubjectCode, Courses.CourseCode, CourseName, Description " +
                "FROM (DegreeRequirements dr " +
                "JOIN Courses " +
                "ON Courses.SubjectCode = dr.SubjectCode AND Courses.CourseCode = dr.CourseCode) " +
                "WHERE RequirementsGroup = ? AND Degree = ? AND ProgramName = ?";
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<HashMap<String, String>> mappedCourses = new ArrayList<>();

        try {
            conn = db.getConn();

            // create statement with sql template
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, category);
            stmt.setString(2, degree);
            stmt.setString(3, programName);


            // get results
            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                HashMap<String, String> course = new HashMap<>();
                course.put("SubjectCode", rs.getString("SubjectCode"));
                course.put("CourseCode", rs.getString("CourseCode"));
                course.put("CourseName", rs.getString("CourseName"));
                course.put("Description", rs.getString("Description"));



                mappedCourses.add(course);
            }

        } catch (SQLException e){
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

        return mappedCourses;
    }

}
