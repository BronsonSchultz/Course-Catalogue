package webApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import db.DBConnection;
import org.json.JSONObject;

/**
 * class who queries database for courses and degrees based on some search parameters
 */
public class CourseQueries {
    DBConnection db;

    /**
     * create a new instance of a CourseQueries object
     */
    public CourseQueries() {
        db = new DBConnection();
    }


    public static void main(String[] args) throws Exception {
        //tests
        CourseQueries querier = new CourseQueries();

        // both fields present
        ArrayList<HashMap<String, String>> l = querier.getCoursesFromDB("CMPT", "4");
        System.out.println(l);


        // just subject present
        l = querier.getCoursesFromDB("CMPT", "");
        System.out.println(l);

        // just course code present
        l = querier.getCoursesFromDB("", "1");
        System.out.println(l);

        // jsonify each map in the arrayList
        JSONObject[] js = querier.jsonifyList(l);

        System.out.println(Arrays.toString(js));

        //garbage
        System.out.println("'openGate(\'' +${gate.gateIp} +'\',\''+${gate.gatePort}+'\')'");
        System.out.println("'javascript:openCourseSideBar(\'' +${course.getString(SubjectCode)} +'\',\''+${course.getString(CourseCode)}+'\',\''+${course.getString(CourseName)}+'\',\''+${course.getString(Description)}+'\')'");
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
        ArrayList<HashMap<String, String>> stringCourses = new ArrayList<>();

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

            // print query results
            while (rs.next()) {
                HashMap<String, String> course = new HashMap<>();
                course.put("SubjectCode", rs.getString("SubjectCode"));
                course.put("CourseCode", rs.getString("CourseCode"));
                course.put("CourseName", rs.getString("CourseName"));
                course.put("Description", rs.getString("Description"));

                stringCourses.add(course);
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
        return stringCourses;
    }


    /**
     * create an array of json objects from an array list
     * @param list the array list of hashMaps returned by the query methods
     * @return array of json objects from an array list
     */
    public JSONObject[] jsonifyList(ArrayList<HashMap<String, String>> list) {
        JSONObject[] jsonArray = new JSONObject[list.size()];
        for (int i = 0; i < list.size(); i++) {
            JSONObject j = new JSONObject(list.get(i));
            jsonArray[i] = j;
        }
        return jsonArray;
    }

}