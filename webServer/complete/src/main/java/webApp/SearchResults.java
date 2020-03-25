package webApp;

import java.util.ArrayList;

import webApp.CoursesQuery;

public class SearchResults {
    private ArrayList<Course> courses;
    private int idx;

    public SearchResults(String sqlString){
        courses = CoursesQuery.query(sqlString);
    }

    public SearchResults(ArrayList<Course> courses){
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course c){
        courses.add(c);
    }

    public Course get(int i){
        return courses.get(i);
    }


}
