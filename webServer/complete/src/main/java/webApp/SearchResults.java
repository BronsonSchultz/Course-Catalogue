package webApp;

import javax.naming.directory.SearchResult;
import java.util.ArrayList;

public class SearchResults {
    private ArrayList<Course> courses;

    public SearchResults(){
        courses = new ArrayList<>();
    }

    public void addCourse(Course c){
        courses.add(c);
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void clearCourses(){
        courses.clear();
    }

    @Override
    public String toString() {
        return "searchResults{" +
                "courses=" + courses +
                '}';
    }

    public static void main(String[] args){
        Course c = new Course("CMPT", 100, "Introduction to Computing", "A survey " +
                "of major computer science areas, combining a breadth of topics with depth via specific examples within " +
                "each topic. Topics include: history of computing, computer applications, analysis and design, " +
                "high level programming, computer software, computer hardware, artificial intelligence, " +
                "and the social impact of computers.");

        SearchResults s = new SearchResults();

        s.addCourse(c);

        System.out.println(s.toString());
    }
}
