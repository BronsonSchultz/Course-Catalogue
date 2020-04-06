package webApp;

public class DeleteFavForm {
    private String subjectCode;
    private String courseCode;

    @Override
    public String toString() {
        return "deleteFavForm{" +
                "subjectCode='" + subjectCode + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }

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
}
