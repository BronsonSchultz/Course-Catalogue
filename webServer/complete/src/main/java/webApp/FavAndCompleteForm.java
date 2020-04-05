package webApp;

public class FavAndCompleteForm {

    private String favourited;
    private String completed;
    private String subjectCode;
    private String courseCode;

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getFavourited() {
        return favourited;
    }

    public void setFavourited(String favourited) {
        this.favourited = favourited;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "FavAndCompleteForm{" +
                "favourited='" + favourited + '\'' +
                ", completed='" + completed + '\'' +
                ", subjectCode='" + subjectCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
