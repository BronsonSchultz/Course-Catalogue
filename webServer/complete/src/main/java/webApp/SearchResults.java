package webApp;

import java.util.ArrayList;


public class SearchResults {
    private ArrayList<Course> courses;
    private int idx;

    public SearchResults() {
        courses = new ArrayList<Course>();
    }

    public SearchResults(ArrayList<Course> courses) {
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
