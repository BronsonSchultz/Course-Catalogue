package webApp;

public class Course {
    private String subjectCode;
    private String number;
    private String title;
    private String description;

    public Course(String subjectCode, String number, String title, String description) {
        this.subjectCode = subjectCode;
        this.number = number;
        this.title = title;
        this.description = description;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "subjectCode='" + subjectCode + '\'' +
                ", number=" + number +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static void main(String[] args){
        Course c = new Course("CMPT", "100", "Introduction to Computing", "A survey " +
                "of major computer science areas, combining a breadth of topics with depth via specific examples within " +
                "each topic. Topics include: history of computing, computer applications, analysis and design, " +
                "high level programming, computer software, computer hardware, artificial intelligence, " +
                "and the social impact of computers.");
        System.out.println(c);
    }
}
